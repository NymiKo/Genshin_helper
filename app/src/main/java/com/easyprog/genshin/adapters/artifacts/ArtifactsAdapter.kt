package com.easyprog.genshin.adapters.artifacts

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.easyprog.genshin.R
import com.easyprog.genshin.adapters.artifacts.ArtifactsAdapter.ArtifactsViewHolder
import com.easyprog.genshin.databinding.ItemArtifactBinding
import com.easyprog.genshin.model.Artifacts
import com.squareup.picasso.Picasso

class ArtifactsAdapter: RecyclerView.Adapter<ArtifactsViewHolder>() {

    var mArtifactsList: List<Artifacts> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtifactsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemArtifactBinding.inflate(inflater, parent, false)

        return ArtifactsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtifactsViewHolder, position: Int) {
        val artifact = mArtifactsList[position]
        with(holder.binding) {
            Picasso.get().load(artifact.imageFlower).resize(400,400).centerInside().into(artifactImage)
            textViewNameArtifactSet.text = artifact.nameSet
        }
    }

    override fun getItemCount(): Int = mArtifactsList.size

    class ArtifactsViewHolder(var binding: ItemArtifactBinding): RecyclerView.ViewHolder(binding.root)

}