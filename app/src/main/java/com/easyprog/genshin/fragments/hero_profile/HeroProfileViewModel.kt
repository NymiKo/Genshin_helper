package com.easyprog.genshin.fragments.hero_profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.easyprog.data.storage.model.HeroesEntity
import com.easyprog.domain.repositories.HeroProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HeroProfileViewModel @Inject constructor(private val heroProfileRepository: HeroProfileRepository) : ViewModel() {

    fun getHero(id: Int): LiveData<HeroesEntity> {
        return heroProfileRepository.getHero(id)
    }

}