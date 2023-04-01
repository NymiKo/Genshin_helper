package com.easyprog.genshin.fragments.goals

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.easyprog.data.storage.additional_models.PriorityWithHero

abstract class GoalsViewModel: ViewModel() {

    abstract val goalsHeroesList: LiveData<List<PriorityWithHero>>
    abstract fun getGoalsHeroes()

}