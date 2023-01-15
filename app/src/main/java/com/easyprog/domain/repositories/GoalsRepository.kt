package com.easyprog.domain.repositories

import androidx.lifecycle.LiveData
import com.easyprog.data.storage.additional_models.PriorityWithHero

interface GoalsRepository {

    fun getPriorityWithHeroesList(): LiveData<List<PriorityWithHero>>

}