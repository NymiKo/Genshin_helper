package com.easyprog.genshin.fragments.hero_settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.easyprog.data.storage.entities.PriorityHeroesEntity
import com.easyprog.domain.repositories.HeroSettingsRepository
import com.easyprog.genshin.model.PriorityHeroes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroSettingsViewModelImpl @Inject constructor(private val repositoryHeroSettings: HeroSettingsRepository) :
    HeroSettingsViewModel() {

    private var _heroSettings = MutableLiveData<PriorityHeroesEntity>()
    val heroSettings: LiveData<PriorityHeroesEntity> = _heroSettings

    fun insertHeroSettings(priorityHeroes: PriorityHeroes) {
        viewModelScope.launch {
            repositoryHeroSettings.insertHeroSetting(priorityHeroes)
        }
    }

    override fun getHeroSettings(idHero: Int) {
        viewModelScope.launch {
            _heroSettings.value = repositoryHeroSettings.getSettingsHeroAsync(idHero)
        }
    }
}