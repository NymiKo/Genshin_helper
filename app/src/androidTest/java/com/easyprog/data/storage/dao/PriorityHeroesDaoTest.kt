package com.easyprog.data.storage.dao

import com.easyprog.data.BaseTestDao
import com.easyprog.data.storage.dao.helpers.HeroesDaoTestHelper
import com.easyprog.data.storage.dao.helpers.PriorityHeroesDaoTestHelper
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class PriorityHeroesDaoTest : BaseTestDao() {

    private val priorityHeroesDao = db.priorityHeroesDao()
    private val heroesDao = db.heroesDao()

    @Test
    fun insertPriorityHeroesAndGetThem() = runBlocking {
        val priorityHeroesList = PriorityHeroesDaoTestHelper().createRandomListOfPriorityHeroes(1, true)
        priorityHeroesDao.insertPriorityHero(priorityHeroesList[0])
        assertEquals(priorityHeroesList[0], priorityHeroesDao.getPriorityHero(1))
    }

    @Test
    fun insertALotOfPriorityHeroesAndGetOneById() = runBlocking {
        val priorityHeroesList = PriorityHeroesDaoTestHelper().createRandomListOfPriorityHeroes(5, true)
        priorityHeroesList.forEach {
            priorityHeroesDao.insertPriorityHero(it)
        }
        assertEquals(priorityHeroesList[2], priorityHeroesDao.getPriorityHero(3))
        assertNotEquals(1, priorityHeroesDao.getPriorityHero(6))
    }

    @Test
    fun insertALotOfPriorityHeroesReplaceAndGetThem() = runBlocking {
        val heroesList = HeroesDaoTestHelper().createRandomListOfHeroes(5)
        val priorityHeroesList = PriorityHeroesDaoTestHelper().createRandomListOfPriorityHeroes(5, false)
        priorityHeroesList.forEach {
            priorityHeroesDao.insertPriorityHero(it)
        }
        val priorityHeroesList2 = PriorityHeroesDaoTestHelper().createRandomListOfPriorityHeroes(5, true)
        priorityHeroesList2.forEach {
            priorityHeroesDao.insertPriorityHero(it)
        }
        heroesDao.insertHeroes(heroesList)
        assertNotEquals(priorityHeroesList[4], priorityHeroesDao.getPriorityHero(5))
        assertEquals(priorityHeroesList2[2], priorityHeroesDao.getPriorityHero(3))
        assertEquals(priorityHeroesList2.size, priorityHeroesDao.getPriorityHeroWithHeroes().size)
    }

    @Test
    fun insertALotOfPriorityHeroesAndGetThemWithHero() = runBlocking {
        val priorityHeroesList = PriorityHeroesDaoTestHelper().createRandomListOfPriorityHeroes(5, false)
        val heroesList = HeroesDaoTestHelper().createRandomListOfHeroes(5)
        priorityHeroesList.forEach {
            priorityHeroesDao.insertPriorityHero(it)
        }
        heroesDao.insertHeroes(heroesList)
        assertEquals(priorityHeroesList.size, priorityHeroesDao.getPriorityHeroWithHeroes().size)
    }
}