package com.easyprog.genshin.fragments.goals

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.easyprog.genshin.adapters.goals.GoalsAdapter
import com.easyprog.genshin.databinding.FragmentGoalsBinding
import com.easyprog.genshin.fragments.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GoalsFragment : BaseFragment<FragmentGoalsBinding>(FragmentGoalsBinding::inflate) {

    private val viewModel: GoalsViewModelImpl by viewModels()
    private lateinit var mAdapter: GoalsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getGoalsHeroes()
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
            viewModel.goalsHeroesList.observe(viewLifecycleOwner) {
                if (it.isEmpty()) binding.textNoGoals.visibility = View.VISIBLE
                else {
                    mAdapter.mGoalsList = it
                    binding.recyclerGoals.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onDestroyView() {
        binding.recyclerGoals.adapter = null
        super.onDestroyView()
    }
}