package com.easyprog.genshin.fragments.hero_profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.easyprog.domain.repositories.HeroProfileRepository
import com.easyprog.genshin.DispatchersList
import com.easyprog.genshin.model.Hero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroProfileViewModelImpl @Inject constructor(
    private val heroProfileRepository: HeroProfileRepository,
    private val dispatchers: DispatchersList
) : HeroProfileViewModel() {

    override val hero = MutableLiveData<Hero>()

    override fun getHero(id: Int) {
        viewModelScope.launch(dispatchers.io()) {
            hero.postValue(heroProfileRepository.getHero(id))
        }
    }
}