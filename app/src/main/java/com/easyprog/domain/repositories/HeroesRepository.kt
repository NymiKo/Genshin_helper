package com.easyprog.domain.repositories

import androidx.lifecycle.LiveData
import com.easyprog.data.storage.model.HeroesEntity

interface HeroesRepository {

    suspend fun getHeroes(): List<HeroesEntity>

}