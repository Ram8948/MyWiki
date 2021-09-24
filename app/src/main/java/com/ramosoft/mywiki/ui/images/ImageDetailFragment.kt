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
import com.bumptech.glide.Glide
import com.ramosoft.mywiki.data.entities.ImageModel
import com.ramosoft.mywiki.data.local.ImageinfoDao
import com.ramosoft.mywiki.data.repository.Repository
import com.ramosoft.mywiki.databinding.ImageDetailFragmentBinding
import com.ramosoft.mywiki.utils.Resource
import com.ramosoft.mywiki.utils.autoCleared

class ImageDetailFragment : Fragment() {
    private var binding: ImageDetailFragmentBinding by autoCleared()
//    private val viewModel: ImageDetailViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ImageDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    companion object {
        private const val ARGUMENT_ACTION = "id"

        fun newInstacne(action: String) : ImageDetailFragment{
            return ImageDetailFragment().apply {
                arguments = bundleOf(ARGUMENT_ACTION to action)
            }
        }
    }
//    private val localDataSource: ImageinfoDao
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        arguments?.getInt(ARGUMENT_ACTION)?.let { viewModel.start(it) }
//        setupObservers()
        println("requireArguments().getInt(ARGUMENT_ACTION) "+requireArguments().getInt(ARGUMENT_ACTION))
//        viewModel.start(requireArguments().getInt(ARGUMENT_ACTION))

    requireArguments().getString(ARGUMENT_ACTION)?.let { bindCharacter(it) }

    }

//    private fun setupObservers() {
//        viewModel.character.observe(viewLifecycleOwner, Observer {
//            when (it.status) {
//                Resource.Status.SUCCESS -> {
//                    bindCharacter(it.data!!)
////                    binding.progressBar.visibility = View.GONE
////                    binding.characterCl.visibility = View.VISIBLE
//                }
//
//                Resource.Status.ERROR ->
//                    Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()
//
//                Resource.Status.LOADING -> {
////                    binding.progressBar.visibility = View.VISIBLE
////                    binding.characterCl.visibility = View.GONE
//                }
//            }
//        })
//    }

    private fun bindCharacter(url: String) {
        Glide.with(binding.root)
            .load(url)
            .into(binding.photoView)
    }
}