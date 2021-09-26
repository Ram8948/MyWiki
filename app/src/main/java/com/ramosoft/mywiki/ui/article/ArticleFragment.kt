package com.ramosoft.mywiki.ui.article

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.ramosoft.mywiki.data.entities.ArticleModel
import com.ramosoft.mywiki.databinding.CharactersFragmentBinding
import com.ramosoft.mywiki.utils.Resource
import com.ramosoft.mywiki.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleFragment : Fragment(), ArticleAdapter.ArticleItemListener {

    private var binding: CharactersFragmentBinding by autoCleared()
    private val viewModel: ArticleViewModel by viewModels()
    private lateinit var adapter: ArticleAdapter

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
    }

    private fun setupRecyclerView() {
        adapter = ArticleAdapter(this)
        binding.ImageinfosRv.layoutManager = LinearLayoutManager(requireContext())
        binding.ImageinfosRv.adapter = adapter
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

    override fun onClickedImageinfo(currentPage: ArticleModel.Query.Page) {
//        findNavController().navigate(
//            R.id.action_ImageinfosFragment_to_ImageinfoDetailFragment,
//            bundleOf("id" to ImageinfoId)
//        )

        val detailPageIntent = Intent(requireActivity(), ArticleDetailActivity::class.java)
        val pageJson = Gson().toJson(currentPage)
        detailPageIntent.putExtra("page", pageJson)
        requireActivity().startActivity(detailPageIntent)
    }
}
