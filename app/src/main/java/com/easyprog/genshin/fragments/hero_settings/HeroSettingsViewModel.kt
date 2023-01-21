package com.easyprog.genshin.fragments.hero_settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.easyprog.data.storage.model.PriorityHeroesEntity
import com.easyprog.domain.repositories.HeroSettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroSettingsViewModel @Inject constructor(private val repositoryHeroSettings: HeroSettingsRepository) :
    ViewModel() {

    private var _heroSettings = MutableLiveData<PriorityHeroesEntity>()
    val heroSettings: LiveData<PriorityHeroesEntity> = _heroSettings

    fun insertHeroSettings(
        idSettings: Int,
        elevationPriority: Boolean,
        talentPriority: Boolean,
        artifactPriority: Boolean,
        idHero: Int
    ) {
        viewModelScope.launch {
            repositoryHeroSettings.checkInsertORUpdateSetting(
                idSettings,
                elevationPriority,
                talentPriority,
                artifactPriority,
                idHero
            )
        }
    }

    fun getHeroSettings(idHero: Int): LiveData<PriorityHeroesEntity> {
        return repositoryHeroSettings.getSettingsHeroAsync(idHero)
    }
}