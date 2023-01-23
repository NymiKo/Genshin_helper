package com.easyprog.genshin.fragments.main

import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import com.easyprog.genshin.R
import com.easyprog.genshin.databinding.FragmentMainBinding
import com.easyprog.genshin.fragments.BaseFragment
import com.easyprog.genshin.utils.load

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val viewModel by viewModels<MainViewModel>()

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onResume() {
        super.onResume()
        setupView()
    }

    private fun setupView() {
        setRandomImageEmblem()
        binding.imageEmblem.setOnClickListener {
            viewModel.changeNumberEmblem()
            setRandomImageEmblem()
        }
        binding.buttonOpenGoals.setOnClickListener {
            findNavController(
                requireActivity(),
                R.id.navHostFragment
            ).navigate(R.id.purposesFragment)
        }
    }

    private fun setRandomImageEmblem() {
        val emblemsArray = arrayOf(
            R.drawable.emblem_anemo,
            R.drawable.emblem_cryo,
            R.drawable.emblem_dendro,
            R.drawable.emblem_fire,
            R.drawable.emblem_geo,
            R.drawable.emblem_gidro,
            R.drawable.emblem_thunder
        )
        binding.imageEmblem.load(emblemsArray[viewModel.numberImageEmblem.value ?: 0])
    }
}