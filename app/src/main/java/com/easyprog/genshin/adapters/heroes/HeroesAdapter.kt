package com.easyprog.genshin.adapters.heroes

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.easyprog.data.storage.model.HeroesEntity
import com.easyprog.genshin.adapters.heroes.HeroesAdapter.HeroesViewHolder
import com.easyprog.genshin.databinding.ItemHeroBinding
import com.easyprog.genshin.model.Heroes
import com.squareup.picasso.Picasso

class HeroesAdapter(
    private val actionListener: HeroesActionListener
): RecyclerView.Adapter<HeroesViewHolder>(), OnClickListener {

    var mHeroesList: List<HeroesEntity> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHeroBinding.inflate(inflater, parent, false)

        binding.cardHero.setOnClickListener(this)

        return HeroesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        val hero = mHeroesList[position]
        with(holder.binding) {
            Picasso.get().load(hero.avatar).centerCrop().fit().into(imageHeroAvatar)
            textHeroName.text = hero.name
            cardHero.tag = hero
        }
    }

    override fun getItemCount(): Int = mHeroesList.size

    class HeroesViewHolder(val binding: ItemHeroBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onClick(view: View) {
        val idHero = view.tag as HeroesEntity
        actionListener.onHeroesProfile(idHero.idHero)
    }

}