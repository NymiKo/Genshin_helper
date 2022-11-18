package com.easyprog.genshin.fragments.artifacts

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.easyprog.genshin.R

class ArtifactsFragment : Fragment() {

    companion object {
        fun newInstance() = ArtifactsFragment()
    }

    private lateinit var viewModel: ArtifactsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.artifacts_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[ArtifactsViewModel::class.java]
        // TODO: Use the ViewModel
    }

}