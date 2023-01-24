package com.easyprog.genshin.fragments.goals

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.easyprog.data.storage.additional_models.PriorityWithHero
import com.easyprog.domain.repositories.GoalsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GoalsViewModel @Inject constructor(private val repositoryGoals: GoalsRepository) :
    ViewModel() {

    private val _goalsHeroesList = MutableLiveData<List<PriorityWithHero>>()
    val goalsHeroesList: LiveData<List<PriorityWithHero>> = _goalsHeroesList

    fun getGoalsHeroes() {
        viewModelScope.launch {
            _goalsHeroesList.postValue(repositoryGoals.getPriorityWithHeroesList())
        }
    }
}