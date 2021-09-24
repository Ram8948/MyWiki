package com.ramosoft.mywiki.ui.images

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ramosoft.mywiki.R
import com.ramosoft.mywiki.databinding.CharactersFragmentBinding
import com.ramosoft.mywiki.utils.Resource
import com.ramosoft.mywiki.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.view.*

@AndroidEntryPoint
class ImageinfosFragment : Fragment(), ImageinfosAdapter.ImageinfoItemListener {

    private var binding: CharactersFragmentBinding by autoCleared()
    private val viewModel: ImageinfosViewModel by viewModels()
    private lateinit var adapter: ImageinfosAdapter
    lateinit var navController: NavController
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

//        val navHostFragment: NavHostFragment = binding.navHostFragment as NavHostFragment
//        navController = navHostFragment.navController

    }


    private fun setupRecyclerView() {
        adapter = ImageinfosAdapter(this)
        binding.ImageinfosRv.layoutManager = GridLayoutManager(requireContext(),2)
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

    override fun onClickedImageinfo(ImageinfoId: String) {
//        binding.navHostFragment.findNavController().navigate(
//            R.id.action_ImageinfosFragment_to_ImageDetailFragment,
//            bundleOf("id" to ImageinfoId)
//        )
        requireActivity().supportFragmentManager.beginTransaction()
            .add((binding.root!!.parent as ViewGroup).id, ImageDetailFragment.newInstacne(ImageinfoId),"IMAGEDETAIL")
            .commit()
    }
}
