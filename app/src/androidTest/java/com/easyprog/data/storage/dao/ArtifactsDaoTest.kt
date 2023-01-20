package com.easyprog.data.storage.dao

import com.easyprog.data.BaseTestDao
import com.easyprog.data.storage.dao.helpers.ArtifactsTestHelper
import org.junit.Assert.*
import org.junit.Test

class ArtifactsDaoTest : BaseTestDao() {

    private val artifactsDao = db.artifactsDao()

    @Test
    @Throws(Exception::class)
    fun whenInsertOneArtifactsThenRead() {
        val artifacts = ArtifactsTestHelper().createRandomListOfArtifacts(1)
        artifactsDao.insertArtifacts(artifacts)

        assertEquals(1, artifactsDao.getSetArtifacts().size)
        assertTrue(artifacts[0] == artifactsDao.getSetArtifact(1))
    }

    @Test
    @Throws(Exception::class)
    fun whenInsertALotOfArtifactsThenReadThem() {
        val artifacts = ArtifactsTestHelper().createRandomListOfArtifacts(5)
        artifactsDao.insertArtifacts(artifacts)
        assertEquals(5, artifactsDao.getSetArtifacts().size)
    }

    @Test
    @Throws(Exception::class)
    fun whenInsertALotOfArtifactsThenReplaceThem() {
        val artifacts = ArtifactsTestHelper().createRandomListOfArtifacts(5)
        artifactsDao.insertArtifacts(artifacts)
        val artifacts2 = ArtifactsTestHelper().createRandomListOfArtifacts(7)
        artifactsDao.insertArtifacts(artifacts2)
        assertEquals(7, artifactsDao.getSetArtifacts().size)
    }

}