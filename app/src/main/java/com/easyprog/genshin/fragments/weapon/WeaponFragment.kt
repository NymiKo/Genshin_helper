package com.easyprog.genshin.fragments.weapon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.easyprog.genshin.R
import com.easyprog.genshin.databinding.FragmentWeaponBinding
import com.easyprog.genshin.fragments.BaseFragment

class WeaponFragment : BaseFragment<FragmentWeaponBinding>(FragmentWeaponBinding::inflate) {

    companion object {
        fun newInstance() = WeaponFragment()
    }

    private lateinit var viewModel: WeaponViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weapon, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[WeaponViewModel::class.java]
        // TODO: Use the ViewModel
    }

}