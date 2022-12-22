package com.easyprog.genshin.fragments.heroes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import com.easyprog.genshin.R
import com.easyprog.genshin.adapters.heroes.HeroesActionListener
import com.easyprog.genshin.adapters.heroes.HeroesAdapter
import com.easyprog.genshin.databinding.HeroesFragmentBinding
import com.easyprog.genshin.utils.ZoomOutPageTransformer

class HeroesFragment : Fragment() {

    companion object {
        fun newInstance() = HeroesFragment()
    }

    private var _binding: HeroesFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var mAdapter: HeroesAdapter

    private val viewModel by viewModels<HeroesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HeroesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        setupView()
    }

    private fun setupView() {
        binding.viewPagerHeroes.setPageTransformer(ZoomOutPageTransformer())
        binding.viewPagerHeroes.adapter = mAdapter.apply {
            viewModel.heroesList.observe(viewLifecycleOwner) {
                mAdapter.mHeroesList = it
            }
        }
    }

    private fun setupAdapter() {
        mAdapter = HeroesAdapter(object : HeroesActionListener{
            override fun onHeroesProfile(idHero: Int) {
                findNavController(
                    requireActivity(),
                    R.id.nav_host_fragment
                ).navigate(R.id.heroProfileFragment, bundleOf("ID_HERO" to idHero))
            }
        })
    }

    override fun onDestroyView() {
        binding.viewPagerHeroes.adapter = null
        _binding = null
        super.onDestroyView()
    }

}