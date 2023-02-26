package com.easyprog.genshin.fragments.main

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.easyprog.genshin.R
import com.easyprog.genshin.adapters.view_pager_banners_adapter.ViewPagerBannersAdapter
import com.easyprog.genshin.databinding.FragmentMainBinding
import com.easyprog.genshin.fragments.BaseFragment
import com.easyprog.genshin.utils.load
import java.util.*

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    companion object {
        const val slidingDotsCount = 4

        fun newInstance() = MainFragment()
    }

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var mAdapterViewPager: ViewPagerBannersAdapter
    private lateinit var slidingImageDots: Array<ImageView?>
    private var currentPage = 0

    private val slidingCallback = object : OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            for (i in 0 until slidingDotsCount) {
                slidingImageDots[i]?.setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), R.drawable.not_active_dot_view_pager_banner)
                )
            }

            slidingImageDots[position]?.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.active_dot_view_pager_banner)
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
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

    private fun setupViewPager() {
        mAdapterViewPager = ViewPagerBannersAdapter()
        binding.viewPagerBanner.apply {
            adapter = mAdapterViewPager.apply {
                viewModel.bannerList.observe(viewLifecycleOwner) {
                    mBannerList = it
                }
            }
            registerOnPageChangeCallback(slidingCallback)
            isUserInputEnabled = false
        }
        slidingImageDots = arrayOfNulls(slidingDotsCount)
        for (i in 0 until slidingDotsCount) {
            slidingImageDots[i] = ImageView(requireContext())
            slidingImageDots[i]?.load(R.drawable.not_active_dot_view_pager_banner)
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(8, 0, 8, 0)
            binding.sliderDots.addView(slidingImageDots[i], params)
        }
        slidingImageDots[0]?.load(R.drawable.active_dot_view_pager_banner)
        val update = Runnable {
            if (currentPage == slidingDotsCount) currentPage = 0
            binding.viewPagerBanner.setCurrentItem(currentPage++, true)
        }

        //Handler(Looper.getMainLooper()).postDelayed(update, 3500)

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
        binding.viewPagerBanner.unregisterOnPageChangeCallback(slidingCallback)
        super.onDestroyView()
    }
}