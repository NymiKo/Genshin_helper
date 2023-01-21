package com.easyprog.data.storage.dao

import com.easyprog.data.BaseTestDao
import com.easyprog.data.storage.dao.helpers.ArtifactsTestHelper
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class ArtifactsDaoTest : BaseTestDao() {

    private val artifactsDao = db.artifactsDao()

    @Test
    @Throws(Exception::class)
    fun whenInsertOneArtifactsThenRead() = runBlocking {
        val artifacts = ArtifactsTestHelper().createRandomListOfArtifacts(1)
        artifactsDao.insertArtifacts(artifacts)

        assertEquals(artifacts.size, artifactsDao.getSetArtifacts().size)
        assertTrue(artifacts[0] == artifactsDao.getSetArtifact(1))
    }

    @Test
    @Throws(Exception::class)
    fun whenInsertALotOfArtifactsThenReadThem() = runBlocking {
        val artifacts = ArtifactsTestHelper().createRandomListOfArtifacts(5)
        artifactsDao.insertArtifacts(artifacts)
        assertEquals(artifacts.size, artifactsDao.getSetArtifacts().size)
    }

    @Test
    @Throws(Exception::class)
    fun whenInsertALotOfArtifactsThenReplaceThem() = runBlocking {
        var artifacts = ArtifactsTestHelper().createRandomListOfArtifacts(5)
        artifactsDao.insertArtifacts(artifacts)
        artifacts = ArtifactsTestHelper().createRandomListOfArtifacts(7)
        artifactsDao.insertArtifacts(artifacts)
        assertEquals(artifacts.size, artifactsDao.getSetArtifacts().size)
    }

}