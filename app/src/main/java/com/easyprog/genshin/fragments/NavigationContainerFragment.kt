package com.easyprog.genshin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.easyprog.genshin.R
import com.easyprog.genshin.databinding.FragmentNavigationContainerBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable

class NavigationContainerFragment : Fragment() {

    private var _binding: FragmentNavigationContainerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentNavigationContainerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}