package com.easyprog.genshin.fragments.goals

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.easyprog.data.storage.additional_models.PriorityWithHero
import com.easyprog.domain.repositories.GoalsRepository
import com.easyprog.genshin.DispatchersList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GoalsViewModelImpl @Inject constructor(
    private val repositoryGoals: GoalsRepository,
    private val dispatcher: DispatchersList
) : GoalsViewModel() {

    override val goalsHeroesList = MutableLiveData<List<PriorityWithHero>>()

    override fun getGoalsHeroes() {
        viewModelScope.launch(dispatcher.io()) {
            goalsHeroesList.postValue(repositoryGoals.getPriorityWithHeroesList())
        }
    }
}