package com.easyprog.genshin.fragments.heroes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.easyprog.data.storage.model.HeroesEntity
import com.easyprog.genshin.model.Heroes

abstract class HeroesViewModel: ViewModel() {

    abstract val heroesList: LiveData<List<Heroes>>

}