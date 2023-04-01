package com.easyprog.genshin.fragments.hero_profile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.easyprog.genshin.R
import com.easyprog.genshin.databinding.FragmentHeroProfileBinding
import com.easyprog.genshin.fragments.BaseFragment
import com.easyprog.genshin.fragments.hero_settings.HeroSettingsFragment
import com.easyprog.genshin.utils.load
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroProfileFragment :
    BaseFragment<FragmentHeroProfileBinding>(FragmentHeroProfileBinding::inflate) {

    companion object {
        private const val HERO_ID_KEY = "ID_HERO"

        fun newArgument(idHero: Int): Bundle {
            return bundleOf(HERO_ID_KEY to idHero)
        }
    }

    private val viewModel by viewModels<HeroProfileViewModelImpl>()

    private val idHero get() = requireArguments().getInt(HERO_ID_KEY)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getHero(idHero)
        setupView()
    }

    @SuppressLint("SetTextI18n")
    private fun setupView() {
        viewModel.hero.observe(viewLifecycleOwner) {
            with(binding) {
                imageProfileHeroAvatar.load(it.avatar)
                textHeroInfo.text =
                    "${getString(R.string.name)} ${it.name}\n\n${getString(R.string.birthday)} ${it.birthday}\n\n${
                        getString(R.string.element)
                    } ${it.element}\n\n${getString(R.string.region)} ${it.region}"
            }
        }
        //binding.textId.text = LocalDate.now().dayOfWeek.value.toString()
        goToSettings()
    }

    private fun goToSettings() {
        binding.buttonSettingsHero.setOnClickListener {
            findNavController().navigate(
                R.id.action_heroProfileFragment_to_heroSettingsFragment,
                HeroSettingsFragment.newArgument(idHero = idHero)
            )
        }
    }
}