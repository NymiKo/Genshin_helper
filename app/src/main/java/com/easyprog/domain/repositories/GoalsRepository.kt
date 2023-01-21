package com.easyprog.domain.repositories

import androidx.lifecycle.LiveData
import com.easyprog.data.storage.additional_models.PriorityWithHero

interface GoalsRepository {

    suspend fun getPriorityWithHeroesList(): List<PriorityWithHero>

}