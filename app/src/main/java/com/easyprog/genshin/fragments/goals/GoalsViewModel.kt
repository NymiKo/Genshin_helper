package com.easyprog.genshin.fragments.goals

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.easyprog.data.storage.additional_models.PriorityWithHero
import com.easyprog.domain.repositories.GoalsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GoalsViewModel @Inject constructor(private val repositoryGoals: GoalsRepository) : ViewModel() {

    fun getGoalsHeroes(): LiveData<List<PriorityWithHero>> {
        return repositoryGoals.getPriorityWithHeroesList()
    }

}