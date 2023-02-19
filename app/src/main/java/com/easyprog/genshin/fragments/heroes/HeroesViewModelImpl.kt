package com.easyprog.genshin.fragments.heroes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.easyprog.data.storage.model.HeroesEntity
import com.easyprog.domain.repositories.HeroesRepository
import com.easyprog.genshin.model.Heroes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroesViewModelImpl @Inject constructor(private val heroesRepository: HeroesRepository) :
    HeroesViewModel() {

    override val heroesList = MutableLiveData<List<Heroes>>()

    init {
        getHeroes()
    }

    private fun getHeroes() {
        viewModelScope.launch {
            heroesList.postValue(heroesRepository.getHeroes())
        }
    }

}