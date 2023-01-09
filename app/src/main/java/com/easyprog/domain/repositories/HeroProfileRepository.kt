package com.easyprog.domain.repositories

import androidx.lifecycle.LiveData
import com.easyprog.data.storage.model.HeroesEntity

interface HeroProfileRepository {

    fun getHero(id: Int): LiveData<HeroesEntity>

}