package com.ramosoft.mywiki.ui.images

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.ramosoft.mywiki.R
import com.ramosoft.mywiki.data.entities.CategoryModel
import com.ramosoft.mywiki.databinding.CharactersFragmentBinding
import com.ramosoft.mywiki.ui.article.ArticleDetailActivity
import com.ramosoft.mywiki.ui.category.CategoryDetailActivity
import com.ramosoft.mywiki.utils.OnLoadMoreListener
import com.ramosoft.mywiki.utils.RecyclerViewLoadMoreScroll
import com.ramosoft.mywiki.utils.Resource
import com.ramosoft.mywiki.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment : Fragment(), CategoryAdapter.CategoryItemListener {

    private var binding: CharactersFragmentBinding by autoCleared()
    private val viewModel: CategoryViewModel by viewModels()
    private lateinit var adapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CharactersFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
        setRVScrollListener()
    }

    private fun setupRecyclerView() {
        adapter = CategoryAdapter(this)
        binding.ImageinfosRv.layoutManager = LinearLayoutManager(requireContext())
        binding.ImageinfosRv.adapter = adapter
    }
    lateinit var scrollListener: RecyclerViewLoadMoreScroll
    private  fun setRVScrollListener() {
        scrollListener = RecyclerViewLoadMoreScroll(binding.ImageinfosRv.layoutManager as LinearLayoutManager)
        scrollListener.setOnLoadMoreListener(object :
            OnLoadMoreListener {
            override fun onLoadMore() {
                viewModel.databaseRepository.getCategoriesNext("").observe(viewLifecycleOwner, Observer {
                    when (it.status) {
                        Resource.Status.SUCCESS -> {
                            binding.progressBar.visibility = View.GONE
                            if (!it.data.isNullOrEmpty()) adapter.addData(ArrayList(it.data))
                            scrollListener.setLoaded()
                        }
                        Resource.Status.ERROR ->
                            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                        Resource.Status.LOADING ->
                            binding.progressBar.visibility = View.VISIBLE
                    }
                })
            }
        })
        binding.ImageinfosRv.addOnScrollListener(scrollListener)
    }

    private fun setupObservers() {
        viewModel.Imageinfos.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()) adapter.setItems(ArrayList(it.data))
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    binding.progressBar.visibility = View.VISIBLE
            }
        })
    }

    override fun onClickedImageinfo(ImageinfoId: CategoryModel.Query.Allcategory) {
        val detailPageIntent = Intent(requireActivity(), CategoryDetailActivity::class.java)
        val pageJson = Gson().toJson(ImageinfoId)
        detailPageIntent.putExtra("page", pageJson)
        requireActivity().startActivity(detailPageIntent)
    }
}
