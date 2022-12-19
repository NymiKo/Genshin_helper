package com.easyprog.genshin.fragments.hero_settings

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import com.easyprog.genshin.R
import com.easyprog.genshin.databinding.FragmentHeroSettingsBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HeroSettingsFragment : Fragment() {

    private var _binding: FragmentHeroSettingsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HeroSettingsViewModel by viewModels()
    private var idHero: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHeroSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        idHero = arguments?.getInt("ID_HERO")
        setupView()
        changeHeroSettings()
    }

    private fun setupView() {
        viewModel.getHeroSettings(idHero!!).observe(viewLifecycleOwner) {
            binding.switchElevationPriority.isChecked = it.elevationPriority ?: false

            binding.switchTalentPriority.isChecked = it.talentPriority ?: false
        }
    }

    private fun changeHeroSettings() {

        binding.switchElevationPriority.setOnCheckedChangeListener { button, isChecked ->
            viewModel.insertHeroSettings(
                isChecked,
                binding.switchTalentPriority.isChecked,
                false,
                idHero!!
            )
        }

        binding.switchTalentPriority.setOnCheckedChangeListener { button, isChecked ->
            viewModel.insertHeroSettings(
                binding.switchElevationPriority.isChecked,
                isChecked,
                false,
                idHero!!
            )
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}