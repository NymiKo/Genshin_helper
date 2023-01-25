package com.easyprog.data.storage.additional_models

import androidx.room.Embedded
import androidx.room.Relation
import com.easyprog.data.storage.model.DungeonsTalentMaterialEntity
import com.easyprog.data.storage.model.MaterialTalentsEntity

data class MaterialTalentsWithDungeons(

    @Embedded
    val materialTalents: MaterialTalentsEntity,

    @Relation(parentColumn = "talent_dungeon_id", entityColumn = "id")
    val dungeonsTalentMaterial: DungeonsTalentMaterialEntity
)
