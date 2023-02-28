package com.easyprog.data.storage.dao

import com.easyprog.data.BaseTestDao
import com.easyprog.data.storage.dao.helpers.DungeonsTalentMaterialDaoTestHelper
import com.easyprog.data.storage.dao.helpers.MaterialTalentsDaoTestHelper
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class MaterialTalentsDaoTest : BaseTestDao() {

    @Test
    fun insertMaterialTalentsAndGetThemById() = runBlocking {
        val materialTalentsList =
            MaterialTalentsDaoTestHelper().createRandomListOfMaterialTalents(1)
        val dungeonsTalentMaterialList =
            DungeonsTalentMaterialDaoTestHelper().createRandomListOfDungeonsTalentMaterial(1)
        materialTalentsDao.insertMaterialTalents(materialTalentsList)
        dungeonsTalentsMaterialDao.insertDungeonsTalentMaterial(dungeonsTalentMaterialList)
        assertTrue(materialTalentsList[0] == materialTalentsDao.getMaterialTalentsWithDungeons(1).materialTalents)
        assertTrue(dungeonsTalentMaterialList[0] == materialTalentsDao.getMaterialTalentsWithDungeons(1).dungeonsTalentMaterial)
    }

    @Test
    fun insertALotOfMaterialTalentsAndGetThemById() = runBlocking {
        val materialTalentsList =
            MaterialTalentsDaoTestHelper().createRandomListOfMaterialTalents(5)
        val dungeonsTalentMaterialList =
            DungeonsTalentMaterialDaoTestHelper().createRandomListOfDungeonsTalentMaterial(5)
        materialTalentsDao.insertMaterialTalents(materialTalentsList)
        dungeonsTalentsMaterialDao.insertDungeonsTalentMaterial(dungeonsTalentMaterialList)
        assertTrue(materialTalentsList[2] == materialTalentsDao.getMaterialTalentsWithDungeons(3).materialTalents)
        assertTrue(dungeonsTalentMaterialList[2] == materialTalentsDao.getMaterialTalentsWithDungeons(3).dungeonsTalentMaterial)
    }

}