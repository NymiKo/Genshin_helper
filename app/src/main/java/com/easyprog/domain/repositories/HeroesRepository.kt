package com.easyprog.domain.repositories

import androidx.lifecycle.LiveData
import com.easyprog.data.storage.model.HeroesEntity

interface HeroesRepository {

    fun getHeroes(): LiveData<List<HeroesEntity>>

}