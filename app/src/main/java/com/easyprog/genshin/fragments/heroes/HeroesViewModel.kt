package com.easyprog.genshin.fragments.heroes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.easyprog.genshin.model.Hero

abstract class HeroesViewModel: ViewModel() {

    abstract val heroesList: LiveData<List<Hero>>

    abstract fun getHeroes()

}