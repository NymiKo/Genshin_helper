package com.easyprog.genshin.fragments.artifacts

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.easyprog.genshin.R
import com.easyprog.genshin.adapters.artifacts.ArtifactsAdapter
import com.easyprog.genshin.databinding.ArtifactsFragmentBinding
import com.easyprog.genshin.databinding.FragmentHeroProfileBinding

class ArtifactsFragment : Fragment() {

    companion object {
        fun newInstance() = ArtifactsFragment()
    }

    private var _binding: ArtifactsFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var mAdapter: ArtifactsAdapter

    private val viewModel by viewModels<ArtifactsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ArtifactsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

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
        _binding = null
        super.onDestroyView()
    }
}