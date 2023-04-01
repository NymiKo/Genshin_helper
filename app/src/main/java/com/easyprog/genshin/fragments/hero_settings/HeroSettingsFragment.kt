package com.easyprog.genshin.fragments.hero_settings

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.graphics.blue
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.easyprog.genshin.databinding.FragmentHeroSettingsBinding
import com.easyprog.genshin.fragments.BaseFragment
import com.easyprog.genshin.model.PriorityHeroes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroSettingsFragment :
    BaseFragment<FragmentHeroSettingsBinding>(FragmentHeroSettingsBinding::inflate) {

    companion object {
        private const val HERO_ID_KEY = "ID_HERO"

        fun newArgument(idHero: Int) = bundleOf(HERO_ID_KEY to idHero)
    }

    private val viewModel: HeroSettingsViewModelImpl by viewModels()

    private val idHero get() = requireArguments().getInt(HERO_ID_KEY)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getHeroSettings(idHero)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        changeHeroSettings()
    }

    private fun setupView() {
        getHeroSettings()
    }

    private fun getHeroSettings() {
        viewModel.heroSettings.observe(viewLifecycleOwner) {
            with(binding) {
                if (it == null) {
                    switchElevationPriority.isChecked = false
                    switchTalentPriority.isChecked = false
                    switchArtifactPriority.isChecked = false
                } else {
                    switchElevationPriority.apply {
                        isChecked = it.elevationPriority
                        jumpDrawablesToCurrentState()
                    }
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
        val priorityHeroes = PriorityHeroes(
            idHero,
            elevationPriority,
            talentPriority,
            artifactPriority
        )
        viewModel.insertHeroSettings(priorityHeroes)
    }
}