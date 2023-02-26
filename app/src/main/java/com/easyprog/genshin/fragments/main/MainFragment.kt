package com.easyprog.genshin.fragments.main

import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import com.easyprog.genshin.R
import com.easyprog.genshin.adapters.view_pager_banners_adapter.ViewPagerBannersAdapter
import com.easyprog.genshin.databinding.FragmentMainBinding
import com.easyprog.genshin.fragments.BaseFragment
import com.easyprog.genshin.utils.enableAutoScroll
import com.easyprog.genshin.utils.load

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    companion object {
        const val slidingDotsCount = 4

        fun newInstance() = MainFragment()
    }

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var mAdapterViewPager: ViewPagerBannersAdapter
    private lateinit var slidingImageDots: Array<ImageView?>
    private var currentBanner = 0

    override fun onResume() {
        super.onResume()
        setupView()
        setupViewPager()
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

    private fun setupViewPager() {
        mAdapterViewPager = ViewPagerBannersAdapter()
        binding.viewPagerBanner.apply {
            adapter = mAdapterViewPager.apply {
                viewModel.bannerList.observe(viewLifecycleOwner) {
                    mBannerList = it
                }
            }
            isUserInputEnabled = true
            enableAutoScroll(slidingDotsCount)
        }
        binding.dotsIndicator.attachTo(binding.viewPagerBanner)

//        Timer().schedule(object : TimerTask() {
//            override fun run() {
//                Handler(Looper.getMainLooper()).post(update)
//            }
//        }, 3500, 3500)
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

    override fun onDestroyView() {
        binding.viewPagerBanner.adapter = null
        binding.viewPagerBanner.enableAutoScroll(slidingDotsCount).cancel()
        super.onDestroyView()
    }
}