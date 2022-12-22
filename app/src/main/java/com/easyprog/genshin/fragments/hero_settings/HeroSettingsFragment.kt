package com.easyprog.genshin.fragments.hero_settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.easyprog.genshin.databinding.FragmentHeroSettingsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroSettingsFragment : Fragment() {

    companion object {
        const val KEY_ID_HERO = "ID_HERO"
    }

    private var _binding: FragmentHeroSettingsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HeroSettingsViewModel by viewModels()

    private var idHero: Int? = null
    private var idSettings: Int? = null


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
        getArgumentsFromBundle()
        setupView()
        changeHeroSettings()
    }

    private fun getArgumentsFromBundle() {
        idHero = arguments?.getInt(KEY_ID_HERO)
    }

    private fun setupView() {
        getHeroSettings()
    }

    private fun getHeroSettings() {
        viewModel.getHeroSettings(idHero!!).observe(viewLifecycleOwner) {
            with(binding) {
                if (it == null) {
                    idSettings = 0
                    switchElevationPriority.isChecked = false
                    switchTalentPriority.isChecked = false
                    switchArtifactPriority.isChecked = false
                } else {
                    idSettings = it.idPriority
                    switchElevationPriority.isChecked = it.elevationPriority
                    switchTalentPriority.isChecked = it.talentPriority
                    switchArtifactPriority.isChecked = it.artifactPriority
                }
            }
        }
    }

    private fun changeHeroSettings() {

        binding.switchElevationPriority.setOnCheckedChangeListener { button, isChecked ->
            insertHeroSetting(
                isChecked,
                binding.switchTalentPriority.isChecked,
                binding.switchArtifactPriority.isChecked
            )
        }

        binding.switchTalentPriority.setOnCheckedChangeListener { button, isChecked ->
            insertHeroSetting(
                binding.switchElevationPriority.isChecked,
                isChecked,
                binding.switchArtifactPriority.isChecked
            )
        }

        binding.switchArtifactPriority.setOnCheckedChangeListener { button, isChecked ->
            insertHeroSetting(
                binding.switchElevationPriority.isChecked,
                binding.switchTalentPriority.isChecked,
                isChecked
            )
        }
    }

    private fun insertHeroSetting(
        elevationPriority: Boolean,
        talentPriority: Boolean,
        artifactPriority: Boolean
    ) {
        viewModel.insertHeroSettings(
            idSettings!!,
            elevationPriority,
            talentPriority,
            artifactPriority,
            idHero!!
        )
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}