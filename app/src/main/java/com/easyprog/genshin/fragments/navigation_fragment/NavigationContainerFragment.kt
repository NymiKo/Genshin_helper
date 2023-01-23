package com.easyprog.genshin.fragments.navigation_fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.easyprog.genshin.R
import com.easyprog.genshin.databinding.FragmentNavigationContainerBinding
import com.easyprog.genshin.fragments.BaseFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable

class NavigationContainerFragment :
    BaseFragment<FragmentNavigationContainerBinding>(FragmentNavigationContainerBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nestedNavHostFragment =
            childFragmentManager.findFragmentById(R.id.bottomNavHostFragment) as NavHostFragment
        val navController = nestedNavHostFragment.navController
        binding.bottomNavView.setupWithNavController(navController)
        setupStyleBottomNavigationView(binding.bottomNavView)
    }

    private fun setupStyleBottomNavigationView(navView: BottomNavigationView) {
        val radius = resources.getDimension(R.dimen.bottom_navigation_view_corner_radius)
        val shapeDrawable: MaterialShapeDrawable = navView.background as MaterialShapeDrawable
        shapeDrawable.shapeAppearanceModel = shapeDrawable.shapeAppearanceModel
            .toBuilder()
            .setTopLeftCorner(CornerFamily.ROUNDED, radius)
            .setTopRightCorner(CornerFamily.ROUNDED, radius)
            .build()
    }
}