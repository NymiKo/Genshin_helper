package com.easyprog.data.storage.dao

import com.easyprog.data.BaseTestDao
import com.easyprog.data.storage.dao.helpers.*
import com.easyprog.data.storage.entities.BuildsHeroesArtifactsEntity
import com.easyprog.data.storage.entities.BuildsHeroesWeaponsEntity
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class BuildsHeroesWeaponsDaoTest: BaseTestDao() {

    companion object {
        private const val HERO_ID = 1
    }

    private val buildsHeroesWeaponsByHeroId = mutableListOf<BuildsHeroesWeaponsEntity>()

    @Before
    fun countBuildsHeroesArtifactsWithHeroId() {
        buildsHeroesWeaponsList.forEach {
            if (it.heroId == HERO_ID) buildsHeroesWeaponsByHeroId.add(it)
        }
    }

    @Test
    fun testGetBuildsHeroesWeaponsByHeroId() = runBlocking {
        assertTrue(buildsHeroesWeaponsByHeroId == buildsHeroesWeaponsDao.getBuildsHeroesWeapons(HERO_ID))
    }
}