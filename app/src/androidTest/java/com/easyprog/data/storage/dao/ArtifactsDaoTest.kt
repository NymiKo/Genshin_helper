package com.easyprog.data.storage.dao

import com.easyprog.data.BaseTestDao
import com.easyprog.data.storage.dao.helpers.ArtifactsTestHelper
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class ArtifactsDaoTest : BaseTestDao() {

    @Test
    @Throws(Exception::class)
    fun testGetArtifacts() = runBlocking {
        assertTrue(artifactsList == artifactsDao.getSetArtifacts())
    }

    @Test
    @Throws(Exception::class)
    fun testGetArtifactsById() = runBlocking {
        assertTrue(artifactsList[0] == artifactsDao.getSetArtifact(artifactsList[0].id))
    }

    @Test
    @Throws(Exception::class)
    fun testReplaceArtifacts() = runBlocking {
        val newArtifactsList = ArtifactsTestHelper().createRandomListOfArtifacts(10)
        artifactsDao.insertArtifacts(newArtifactsList)
        assertFalse(artifactsList[4] == artifactsDao.getSetArtifact(artifactsList[4].id))
        assertTrue(newArtifactsList[2] == artifactsDao.getSetArtifact(newArtifactsList[2].id))
        assertTrue(newArtifactsList == artifactsDao.getSetArtifacts())
    }

}