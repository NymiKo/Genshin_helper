package com.easyprog.genshin.fragments.goals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.easyprog.genshin.adapters.goals.GoalsAdapter
import com.easyprog.genshin.databinding.FragmentGoalsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GoalsFragment : Fragment() {

    private var _binding: FragmentGoalsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: GoalsViewModel by viewModels()
    private lateinit var mAdapter: GoalsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentGoalsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        setupRecyclerView()
    }

    private fun setupAdapter() {
        mAdapter = GoalsAdapter()
    }

    private fun setupRecyclerView() {
        binding.recyclerGoals.layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerGoals.adapter = mAdapter.apply {
            viewModel.getGoalsHeroes().observe(viewLifecycleOwner) {
                if (it.isEmpty()) binding.textNoGoals.visibility = View.VISIBLE
                else {
                    mAdapter.mGoalsList = it
                    binding.recyclerGoals.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}