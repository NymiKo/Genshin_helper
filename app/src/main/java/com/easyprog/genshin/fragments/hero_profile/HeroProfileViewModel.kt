package com.easyprog.genshin.fragments.hero_profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.easyprog.data.storage.model.HeroesEntity
import com.easyprog.domain.repositories.HeroProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroProfileViewModel @Inject constructor(private val heroProfileRepository: HeroProfileRepository) : ViewModel() {

    private val _hero = MutableLiveData<HeroesEntity>()
    val hero: LiveData<HeroesEntity> = _hero

    fun getHero(id: Int) {
        viewModelScope.launch {
            _hero.value = heroProfileRepository.getHero(id)
        }
    }

}