package com.easyprog.genshin.fragments.hero_settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.easyprog.data.storage.entities.PriorityHeroesEntity
import com.easyprog.domain.repositories.HeroSettingsRepository
import com.easyprog.genshin.DispatchersList
import com.easyprog.genshin.model.PriorityHeroes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroSettingsViewModelImpl @Inject constructor(
    private val repositoryHeroSettings: HeroSettingsRepository,
    private val dispatchers: DispatchersList
) : HeroSettingsViewModel() {

    override val heroSettings = MutableLiveData<PriorityHeroes>()

    fun insertHeroSettings(priorityHeroes: PriorityHeroes) {
        viewModelScope.launch(dispatchers.io()) {
            repositoryHeroSettings.insertHeroSetting(priorityHeroes)
        }
    }

    override fun getHeroSettings(idHero: Int) {
        viewModelScope.launch(dispatchers.io()) {
            heroSettings.postValue(repositoryHeroSettings.getSettingsHeroAsync(idHero))
        }
    }
}