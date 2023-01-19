package com.easyprog.genshin.activity

import androidx.lifecycle.ViewModel
import com.easyprog.data.storage.model.HeroesEntity
import com.easyprog.data.storage.model.WeaponsEntity
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

    fun insertHeroesList() {
        repositoryMainActivity.insertHeroesList(createHeroesData())
        repositoryMainActivity.insertWeaponsList(createWeaponsData())
    }

    fun createHeroesData(): List<HeroesEntity> {
        val mockData: MutableList<HeroesEntity> = mutableListOf()
        mockData.add(HeroesEntity(idHero = 1, name = "Итто", avatar = R.drawable.itto, birthday = "06.02", element = "Гео", region = "Инадзума", idTalentMaterial = 0))
        mockData.add(HeroesEntity(idHero = 2, name = "Чжун Ли", avatar = R.drawable.zhongli, birthday = "02.01", element = "Гео", region = "Ли Юэ", idTalentMaterial = 0))
        mockData.add(HeroesEntity(idHero = 3, name = "Венти", avatar = R.drawable.venti, birthday = "03.12", element = "Анемо", region = "Мондштадт", idTalentMaterial = 0))
        mockData.add(HeroesEntity(idHero = 4, name = "Сяо", avatar = R.drawable.xiao, birthday = "10.05", element = "Анемо", region = "Ли Юэ", idTalentMaterial = 0))
        mockData.add(HeroesEntity(idHero = 5, name = "Дилюк", avatar = R.drawable.diluc, birthday = "018.09", element = "Пиро", region = "Мондштадт", idTalentMaterial = 0))

        return mockData
    }

    fun createWeaponsData(): List<WeaponsEntity> {
        val mockData: MutableList<WeaponsEntity> = mutableListOf()
        mockData.add(WeaponsEntity(1, "Аква Симулякрум", R.drawable.weapon_akva_simulyakrum, "55-509", "Крит.урон", 0))
        mockData.add(WeaponsEntity(2, "Караснорогий Камнеруб", R.drawable.weapon_krasnorogiy_kamnerub, "80-480", "Крит.урон", 3))
        mockData.add(WeaponsEntity(3, "Нефритовый Коршун", R.drawable.weapon_nefritovyy_korshun, "20-607", "Шанс крита", 5))
        mockData.add(WeaponsEntity(4, "Посох Хомы", R.drawable.weapon_posoh_homy, "50-490", "Крит.урон", 1))
        mockData.add(WeaponsEntity(5, "Волчья Погибель", R.drawable.weapon_volchya_pogibel, "30-708", "Сила атаки", 8))

        return mockData
    }

}