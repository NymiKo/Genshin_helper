package com.easyprog.genshin.fragments.hero_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.easyprog.genshin.R
import com.easyprog.genshin.databinding.FragmentHeroProfileBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroProfileFragment : Fragment() {

    companion object {
        fun newInstance() = HeroProfileFragment()
    }

    private var _binding: FragmentHeroProfileBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<HeroProfileViewModel>()

    private var idHero = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHeroProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        idHero = arguments?.getInt("ID_HERO")!!
        viewModel.getHero(idHero)
        setupView()
    }

    private fun setupView() {
        viewModel.getHero(idHero).observe(viewLifecycleOwner) {
            with(binding) {
                Picasso.get().load(it.avatar).fit().centerCrop().into(imageProfileHeroAvatar)
                textHeroInfo.text =
                    "${getString(R.string.name)} ${it.name}\n\n${getString(R.string.birthday)} ${it.birthday}\n\n${
                        getString(R.string.element)
                    } ${it.element}\n\n${getString(R.string.region)} ${it.region}"
            }
        }
        //binding.textId.text = LocalDate.now().dayOfWeek.value.toString()
        //binding.textId.text = arguments?.getInt("ID_HERO").toString()
        goToSettings()
    }

    private fun goToSettings() {
        binding.imageSettings.setOnClickListener {
            findNavController().navigate(
                R.id.action_heroProfileFragment_to_heroSettingsFragment,
                bundleOf("ID_HERO" to idHero)
            )
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}