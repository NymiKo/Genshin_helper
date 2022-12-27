package com.easyprog.genshin.adapters.purposes

import android.annotation.SuppressLint
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.easyprog.data.storage.additional_models.PriorityWithHero
import com.easyprog.genshin.R
import com.easyprog.genshin.adapters.purposes.PurposesAdapter.*
import com.easyprog.genshin.databinding.ItemPurposeHeroBinding
import com.squareup.picasso.Picasso

class PurposesAdapter : RecyclerView.Adapter<PurposesViewHolder>() {

    var mPurposesList: List<PriorityWithHero> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PurposesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPurposeHeroBinding.inflate(inflater, parent, false)

        return PurposesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PurposesViewHolder, position: Int) {
        val purpose = mPurposesList[position]
        with(holder.binding) {
            if (purpose.priority.elevationPriority) textElevationPurpose.visibility = View.VISIBLE
            if (purpose.priority.talentPriority) textTalentsPurpose.visibility = View.VISIBLE
            if (purpose.priority.artifactPriority) textArtifactsPurpose.visibility = View.VISIBLE
            val avatar = purpose.heroAvatar?.avatar ?: R.drawable.ic_baseline_sentiment_very_dissatisfied
            Picasso.get().load(avatar).centerCrop().fit().into(imagePurposeAvatarHero)
        }
    }

    override fun getItemCount() = mPurposesList.size

    class PurposesViewHolder(val binding: ItemPurposeHeroBinding): RecyclerView.ViewHolder(binding.root)

}