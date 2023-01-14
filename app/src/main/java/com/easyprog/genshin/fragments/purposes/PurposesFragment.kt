package com.easyprog.genshin.fragments.purposes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.easyprog.data.storage.RoomDatabaseApp
import com.easyprog.genshin.R
import com.easyprog.genshin.adapters.purposes.PurposesAdapter
import com.easyprog.genshin.databinding.FragmentPurposesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PurposesFragment : Fragment() {

    private var _binding: FragmentPurposesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PurposesViewModel by viewModels()
    private lateinit var mAdapter: PurposesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPurposesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        setupRecyclerView()
    }

    private fun setupAdapter() {
        mAdapter = PurposesAdapter()
    }

    private fun setupRecyclerView() {
        binding.recyclerPurposes.layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerPurposes.adapter = mAdapter.apply {
            viewModel.getPurposesHeroes().observe(viewLifecycleOwner) {
                if (it.isEmpty()) binding.textViewNoGoals.visibility = View.VISIBLE
                else mAdapter.mPurposesList = it
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}