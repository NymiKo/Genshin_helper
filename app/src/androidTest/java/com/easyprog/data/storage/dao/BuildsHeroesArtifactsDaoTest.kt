package com.easyprog.data.storage.dao

import com.easyprog.data.BaseTestDao
import com.easyprog.data.storage.dao.helpers.*
import com.easyprog.data.storage.entities.BuildsHeroesArtifactsEntity
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class BuildsHeroesArtifactsDaoTest : BaseTestDao() {

    companion object {
        private const val HERO_ID = 1
    }

    private val buildsHeroesArtifactsByHeroId = mutableListOf<BuildsHeroesArtifactsEntity>()

    @Before
    fun countBuildsHeroesArtifactsWithHeroId() {
        buildsHeroesArtifactsList.forEach {
            if (it.heroId == HERO_ID) buildsHeroesArtifactsByHeroId.add(it)
        }
    }

    @Test
    @Throws(Exception::class)
    fun testGetBuildsHeroesArtifactsByHeroId() = runBlocking {
        assertTrue(buildsHeroesArtifactsByHeroId == buildsHeroesArtifactsDao.getBuildsArtifactsHero(HERO_ID))
    }
}