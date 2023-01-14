package com.easyprog.genshin.fragments.heroes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.easyprog.data.storage.model.HeroesEntity
import com.easyprog.domain.repositories.HeroesRepository
import com.easyprog.genshin.R
import com.easyprog.genshin.model.Heroes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HeroesViewModel @Inject constructor(private val heroesRepository: HeroesRepository) : ViewModel() {

    private var _heroesList = MutableLiveData<List<HeroesEntity>>()
    var heroesList: LiveData<List<HeroesEntity>> = _heroesList

    init {
        getHeroes()
    }

    private fun getHeroes() {
        heroesList = heroesRepository.getHeroes()
    }

}