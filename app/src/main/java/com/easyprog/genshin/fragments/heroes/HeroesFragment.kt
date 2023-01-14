package com.easyprog.genshin.fragments.heroes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import com.easyprog.genshin.R
import com.easyprog.genshin.adapters.heroes.HeroesActionListener
import com.easyprog.genshin.adapters.heroes.HeroesAdapter
import com.easyprog.genshin.databinding.FragmentHeroesBinding
import com.easyprog.genshin.fragments.hero_profile.HeroProfileFragment
import com.easyprog.genshin.utils.ZoomOutPageTransformer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroesFragment : Fragment() {

    companion object {
        fun newInstance() = HeroesFragment()
    }

    private var _binding: FragmentHeroesBinding? = null
    private val binding get() = _binding!!

    private lateinit var mAdapter: HeroesAdapter

    private val viewModel by viewModels<HeroesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHeroesBinding.inflate(inflater, container, false)
        return binding.root
    }

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
        mAdapter = HeroesAdapter(object : HeroesActionListener {
            override fun onHeroesProfile(idHero: Int) {
                findNavController(
                    requireActivity(),
                    R.id.nav_host_fragment
                ).navigate(
                    R.id.action_navigationContainerFragment_to_heroProfileFragment,
                    HeroProfileFragment.newArgument(idHero = idHero)
                )
            }
        })
    }

    override fun onDestroyView() {
        binding.viewPagerHeroes.adapter = null
        _binding = null
        super.onDestroyView()
    }

}