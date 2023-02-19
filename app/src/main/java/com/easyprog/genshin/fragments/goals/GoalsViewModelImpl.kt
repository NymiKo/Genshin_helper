package com.easyprog.genshin.fragments.goals

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.easyprog.data.storage.additional_models.PriorityWithHero
import com.easyprog.domain.repositories.GoalsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GoalsViewModelImpl @Inject constructor(private val repositoryGoals: GoalsRepository) :
    GoalsViewModel() {

    override val goalsHeroesList = MutableLiveData<List<PriorityWithHero>>()

    init {
        getGoalsHeroes()
    }

    private fun getGoalsHeroes() {
        viewModelScope.launch {
            goalsHeroesList.postValue(repositoryGoals.getPriorityWithHeroesList())
        }
    }
}