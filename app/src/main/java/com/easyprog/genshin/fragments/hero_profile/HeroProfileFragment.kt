package com.easyprog.genshin.fragments.hero_profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.easyprog.genshin.R
import com.easyprog.genshin.adapters.HeroesActionListener
import com.easyprog.genshin.databinding.FragmentHeroProfileBinding

class HeroProfileFragment : Fragment() {

    companion object {
        fun newInstance() = HeroProfileFragment()
    }

    private var _binding: FragmentHeroProfileBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<HeroProfileViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHeroProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textId.text = arguments?.getInt("ID_HERO").toString()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}