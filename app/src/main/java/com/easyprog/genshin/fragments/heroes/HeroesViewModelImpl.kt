package com.easyprog.genshin.fragments.heroes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.easyprog.domain.repositories.HeroesRepository
import com.easyprog.genshin.DispatchersList
import com.easyprog.genshin.model.Hero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroesViewModelImpl @Inject constructor(
    private val heroesRepository: HeroesRepository,
    private val dispatchers: DispatchersList
) : HeroesViewModel() {

    override val heroesList = MutableLiveData<List<Hero>>()

    override fun getHeroes() {
        viewModelScope.launch(dispatchers.io()) {
            heroesList.postValue(heroesRepository.getHeroes())
        }
    }

}