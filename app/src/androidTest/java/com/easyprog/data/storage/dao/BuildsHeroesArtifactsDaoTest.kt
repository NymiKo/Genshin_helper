package com.easyprog.data.storage.dao

import com.easyprog.data.BaseTestDao
import com.easyprog.data.storage.dao.helpers.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class BuildsHeroesArtifactsDaoTest : BaseTestDao() {

    @Before
    fun addNecessaryDataToDatabase() = runBlocking {
        val materialTalentsList = MaterialTalentsDaoTestHelper().createRandomListOfMaterialTalents(5)
        val heroesList = HeroesDaoTestHelper().createRandomListOfHeroes(5)
        val dungeonsTalentsMaterialList = DungeonsTalentMaterialDaoTestHelper().createRandomListOfDungeonsTalentMaterial(5)
        dungeonsTalentsMaterialDao.insertDungeonsTalentMaterial(dungeonsTalentsMaterialList)
        materialTalentsDao.insertMaterialTalents(materialTalentsList)
        heroesDao.insertHeroes(heroesList)
    }

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