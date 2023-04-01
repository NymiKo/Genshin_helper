package com.easyprog.data.storage.dao

import com.easyprog.data.BaseTestDao
import com.easyprog.data.storage.dao.helpers.DungeonsTalentMaterialDaoTestHelper
import com.easyprog.data.storage.dao.helpers.MaterialTalentsDaoTestHelper
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class MaterialTalentsDaoTest : BaseTestDao() {

    @Test
    fun testGetMaterialTalentsById() = runBlocking {
        assertTrue(materialTalentsList[0] == materialTalentsDao.getMaterialTalentsWithDungeons(materialTalentsList[0].id).materialTalents)
        assertTrue(dungeonsTalentsMaterialList[0] == materialTalentsDao.getMaterialTalentsWithDungeons(materialTalentsList[0].id).dungeonsTalentMaterial)
    }
}