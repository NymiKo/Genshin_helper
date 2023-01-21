package com.easyprog.data.storage.dao

import com.easyprog.data.BaseTestDao
import com.easyprog.data.storage.dao.helpers.BuildsHeroesArtifactsDaoTestHelper
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class BuildsHeroesArtifactsDaoTest : BaseTestDao() {

    private val buildsHeroesArtifactsDao = db.buildsHeroesArtifactsDao()

    @Test
    @Throws(Exception::class)
    fun insertBuildsHeroesArtifactsAndGetThemById() = runBlocking {
        val buildsHeroesArtifacts =
            BuildsHeroesArtifactsDaoTestHelper().createRandomListOfBuildsHeroesArtifacts(5, true)
        buildsHeroesArtifactsDao.insertBuildsHeroes(buildsHeroesArtifacts)

        assertEquals(1, buildsHeroesArtifactsDao.getBuildsArtifactsHero(1).size)
    }

    @Test
    @Throws(Exception::class)
    fun insertBuildsHeroesArtifactsAndGetThem() = runBlocking {
        val buildsHeroesArtifacts =
            BuildsHeroesArtifactsDaoTestHelper().createRandomListOfBuildsHeroesArtifacts(1, true)
        buildsHeroesArtifactsDao.insertBuildsHeroes(buildsHeroesArtifacts)

        assertEquals(1, buildsHeroesArtifactsDao.getBuildsArtifactsHero(1).size)
    }

    @Test
    @Throws(Exception::class)
    fun insertALotOfBuildsHeroesArtifactsAndGetThem() = runBlocking {
        val buildsHeroesArtifacts =
            BuildsHeroesArtifactsDaoTestHelper().createRandomListOfBuildsHeroesArtifacts(10, false)
        buildsHeroesArtifactsDao.insertBuildsHeroes(buildsHeroesArtifacts)

        assertEquals(10, buildsHeroesArtifactsDao.getBuildsArtifactsHero(1).size)
    }

}