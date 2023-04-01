package com.easyprog.data.storage.dao

import com.easyprog.data.BaseTestDao
import com.easyprog.data.storage.dao.helpers.HeroesDaoTestHelper
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class HeroesDaoTest : BaseTestDao() {

    @Test
    fun testGetHeroes() = runBlocking {
        assertTrue(heroesList == heroesDao.getHeroes())
    }

    @Test
    fun testGetHeroById() = runBlocking {
        assertTrue(heroesList[0] == heroesDao.getHero(heroesList[0].id))
    }

    @Test
    fun testReplaceHeroes() = runBlocking {
        val heroesList = HeroesDaoTestHelper().createRandomListOfHeroes(15)
        heroesDao.insertHeroes(heroesList)
        assertTrue(heroesList == heroesDao.getHeroes())
    }


}