package com.easyprog.genshin.fragments.heroes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import com.easyprog.genshin.R
import com.easyprog.genshin.adapters.heroes.HeroesActionListener
import com.easyprog.genshin.adapters.heroes.HeroesAdapter
import com.easyprog.genshin.databinding.FragmentHeroesBinding
import com.easyprog.genshin.fragments.BaseFragment
import com.easyprog.genshin.fragments.hero_profile.HeroProfileFragment
import com.easyprog.genshin.utils.ZoomOutPageTransformer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroesFragment : BaseFragment<FragmentHeroesBinding>(FragmentHeroesBinding::inflate) {

    companion object {
        fun newInstance() = HeroesFragment()
    }

    private lateinit var mAdapter: HeroesAdapter

    private val viewModel by viewModels<HeroesViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPagerAdapter()
        setupView()
    }

    private fun setupView() {
        setupViewPager()
    }

    private fun setupViewPager() {

        binding.viewPagerHeroes.apply {
            setPageTransformer(ZoomOutPageTransformer())

            adapter = mAdapter.apply {
                viewModel.heroesList.observe(viewLifecycleOwner) { heroesEntity ->
                    mAdapter.mHeroesList = heroesEntity.sortedBy { it.name }
                }
            }
        }
    }

    private fun setupViewPagerAdapter() {
        mAdapter = HeroesAdapter(object : HeroesActionListener<Int> {
            override fun onClick(idHero: Int) {
                findNavController(
                    requireActivity(),
                    R.id.navHostFragment
                ).navigate(
                    R.id.action_navigationContainerFragment_to_heroProfileFragment,
                    HeroProfileFragment.newArgument(idHero = idHero)
                )
            }
        })
    }

    override fun onDestroyView() {
        binding.viewPagerHeroes.adapter = null
        super.onDestroyView()
    }
}