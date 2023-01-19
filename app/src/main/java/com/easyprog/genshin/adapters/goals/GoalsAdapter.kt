package com.easyprog.genshin.adapters.goals

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.easyprog.data.storage.additional_models.PriorityWithHero
import com.easyprog.genshin.R
import com.easyprog.genshin.adapters.goals.GoalsAdapter.*
import com.easyprog.genshin.databinding.ItemGoalsHeroBinding
import com.easyprog.genshin.utils.load

class GoalsAdapter : RecyclerView.Adapter<PurposesViewHolder>() {

    var mGoalsList: List<PriorityWithHero> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PurposesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemGoalsHeroBinding.inflate(inflater, parent, false)

        return PurposesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PurposesViewHolder, position: Int) {
        val purpose = mGoalsList[position]
        with(holder.binding) {
            if (purpose.priority.elevationPriority) textElevationGoals.visibility = View.VISIBLE
            if (purpose.priority.talentPriority) textTalentsGoals.visibility = View.VISIBLE
            if (purpose.priority.artifactPriority) textArtifactsGoals.visibility = View.VISIBLE
            val avatar =
                purpose.heroAvatar?.avatar ?: R.drawable.ic_baseline_sentiment_very_dissatisfied
            imageGoalsAvatarHero.load(avatar)
        }
    }

    override fun getItemCount() = mGoalsList.size

    class PurposesViewHolder(val binding: ItemGoalsHeroBinding) :
        RecyclerView.ViewHolder(binding.root)

}