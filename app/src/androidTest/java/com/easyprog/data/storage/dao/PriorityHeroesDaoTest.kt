package com.easyprog.data.storage.dao

import com.easyprog.data.BaseTestDao
import com.easyprog.data.storage.additional_models.PriorityWithHero
import com.easyprog.data.storage.additional_models.hero.HeroAvatar
import com.easyprog.data.storage.dao.helpers.HeroesDaoTestHelper
import com.easyprog.data.storage.dao.helpers.PriorityHeroesDaoTestHelper
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class PriorityHeroesDaoTest : BaseTestDao() {

    @Test
    fun testGetPriorityHeroById() = runBlocking {
        assertEquals(priorityHeroesList[0], priorityHeroesDao.getPriorityHero(priorityHeroesList[0].heroId))
    }

    @Test
    fun testReplacePriorityHeroes() = runBlocking {
        val newPriorityHeroesList = PriorityHeroesDaoTestHelper().createRandomListOfPriorityHeroes(10, false)
        newPriorityHeroesList.forEach { priorityHeroesDao.insertPriorityHero(it) }
        assertFalse(priorityHeroesList[4] == priorityHeroesDao.getPriorityHero(priorityHeroesList[4].heroId))
        assertTrue(newPriorityHeroesList[2] == priorityHeroesDao.getPriorityHero(newPriorityHeroesList[2].heroId))
        assertTrue(newPriorityHeroesList.size == priorityHeroesDao.getPriorityHeroWithHeroes().size)
    }

    @Test
    fun testGetPriorityWithHeroes() = runBlocking {
        val priorityWithHeroes = mutableListOf<PriorityWithHero>()
        for (i in 0..9) {
            priorityWithHeroes.add(PriorityWithHero(priorityHeroesList[i], HeroAvatar(heroesList[i].avatar)))
        }
        assertTrue(priorityWithHeroes == priorityHeroesDao.getPriorityHeroWithHeroes())
    }
}