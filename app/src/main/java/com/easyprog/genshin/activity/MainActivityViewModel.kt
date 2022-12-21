package com.easyprog.genshin.activity

import androidx.lifecycle.ViewModel
import com.easyprog.data.storage.model.HeroesEntity
import com.easyprog.domain.repositories.MainActivityRepository
import com.easyprog.genshin.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repositoryMainActivity: MainActivityRepository) :
    ViewModel() {

    init {
        insertHeroesList()
    }

    private fun insertHeroesList() {
        repositoryMainActivity.insertHeroesList(createHeroesData())
    }

    private fun createHeroesData(): List<HeroesEntity> {
        val mockData: MutableList<HeroesEntity> = ArrayList()
        mockData.add(HeroesEntity(name = "Итто", avatar = R.drawable.itto, idTalentMaterial = 0))
        mockData.add(HeroesEntity(name = "Чжун Ли", avatar = R.drawable.zhongli, idTalentMaterial = 0))
        mockData.add(HeroesEntity(name = "Венти", avatar = R.drawable.venti, idTalentMaterial = 0))
        mockData.add(HeroesEntity(name = "Сяо", avatar = R.drawable.xiao, idTalentMaterial = 0))
        mockData.add(HeroesEntity(name = "Дилюк", avatar = R.drawable.diluc, idTalentMaterial = 0))

        return mockData
    }

}