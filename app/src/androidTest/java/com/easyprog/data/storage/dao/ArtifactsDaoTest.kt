package com.easyprog.data.storage.dao

import com.easyprog.data.BaseTestDao
import com.easyprog.data.storage.dao.helpers.ArtifactsTestHelper
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class ArtifactsDaoTest : BaseTestDao() {

    @Test
    @Throws(Exception::class)
    fun testReadArtifacts() = runBlocking {
        assertEquals(10, artifactsDao.getSetArtifacts().size)
        assertTrue(artifactsList == artifactsDao.getSetArtifacts())
    }

    @Test
    @Throws(Exception::class)
    fun testReadArtifactsById() = runBlocking {
        assertEquals(artifactsList[0], artifactsDao.getSetArtifact(artifactsList[0].id))
        assertTrue(artifactsList[0] == artifactsDao.getSetArtifact(artifactsList[0].id))
    }

    @Test
    @Throws(Exception::class)
    fun testReplaceArtifacts() = runBlocking {
        val artifacts = ArtifactsTestHelper().createRandomListOfArtifacts(15)
        artifactsDao.insertArtifacts(artifacts)
        assertEquals(artifacts.size, artifactsDao.getSetArtifacts().size)
        assertTrue(artifacts == artifactsDao.getSetArtifacts())
    }

}