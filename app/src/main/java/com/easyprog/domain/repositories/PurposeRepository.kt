package com.easyprog.domain.repositories

import androidx.lifecycle.LiveData
import com.easyprog.data.storage.additional_models.PriorityWithHero
import com.easyprog.data.storage.model.HeroesEntity

interface PurposeRepository {

    fun getPriorityWithHeroesList(): LiveData<List<PriorityWithHero>>

}