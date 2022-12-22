package com.easyprog.genshin.fragments.purposes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.easyprog.genshin.R
import com.easyprog.genshin.databinding.FragmentPurposesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PurposesFragment : Fragment() {

    private var _binding: FragmentPurposesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PurposesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPurposesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getPurposesHeroes().observe(viewLifecycleOwner) {
            Log.e("PRIORITY", it.toString())
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}