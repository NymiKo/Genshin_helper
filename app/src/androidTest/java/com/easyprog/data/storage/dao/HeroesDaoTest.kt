package com.easyprog.data.storage.dao

import com.easyprog.data.BaseTestDao
import com.easyprog.data.storage.dao.helpers.HeroesDaoTestHelper
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class HeroesDaoTest : BaseTestDao() {

    private val heroesDao = db.heroesDao()

    @Test
    fun insertHeroAndGetHis() = runBlocking {
        val heroesList = HeroesDaoTestHelper().createRandomListOfHeroes(1)
        heroesDao.insertHeroes(heroesList)

        assertEquals(heroesList.size, heroesDao.getHeroes().size)
        assertTrue(heroesList[0] == heroesDao.getHeroes()[0])
    }

    @Test
    fun insertALotOfHeroesAndGEtThem() = runBlocking {
        val heroesList = HeroesDaoTestHelper().createRandomListOfHeroes(5)
        heroesDao.insertHeroes(heroesList)

        assertEquals(heroesList.size, heroesDao.getHeroes().size)
        assertTrue(heroesList == heroesDao.getHeroes())
    }

    @Test
    fun insertHeroAndGetById() = runBlocking {
        val heroesList = HeroesDaoTestHelper().createRandomListOfHeroes(5)
        heroesDao.insertHeroes(heroesList)

        assertEquals(1, arrayOf(heroesDao.getHero(3)).size)
        assertTrue(heroesList[2] == heroesDao.getHero(3))
    }

    @Test
    fun insertHeroReplaceAndGetById() = runBlocking {
        var heroesList = HeroesDaoTestHelper().createRandomListOfHeroes(5)
        heroesDao.insertHeroes(heroesList)
        heroesList = HeroesDaoTestHelper().createRandomListOfHeroes(8)
        heroesDao.insertHeroes(heroesList)

        assertEquals(heroesList.size, heroesDao.getHeroes().size)
        assertTrue(heroesList == heroesDao.getHeroes())
    }


}