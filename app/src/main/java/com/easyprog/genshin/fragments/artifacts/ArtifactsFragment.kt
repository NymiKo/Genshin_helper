package com.easyprog.genshin.fragments.artifacts

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.easyprog.genshin.adapters.artifacts.ArtifactsAdapter
import com.easyprog.genshin.databinding.FragmentArtifactsBinding
import com.easyprog.genshin.fragments.BaseFragment

class ArtifactsFragment :
    BaseFragment<FragmentArtifactsBinding>(FragmentArtifactsBinding::inflate) {

    companion object {
        fun newInstance() = ArtifactsFragment()
    }

    private lateinit var mAdapter: ArtifactsAdapter

    private val viewModel by viewModels<ArtifactsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        setupRecyclerView()
    }

    private fun setupAdapter() {
        mAdapter = ArtifactsAdapter()
    }

    private fun setupRecyclerView() {
        binding.recyclerViewArtifactsList.layoutManager = GridLayoutManager(requireActivity(), 2)
        binding.recyclerViewArtifactsList.adapter = mAdapter.apply {
            viewModel.artifactsList.observe(viewLifecycleOwner) {
                mAdapter.mArtifactsList = it as ArrayList
            }
        }
    }

    override fun onDestroyView() {
        binding.recyclerViewArtifactsList.adapter = null
        super.onDestroyView()
    }
}