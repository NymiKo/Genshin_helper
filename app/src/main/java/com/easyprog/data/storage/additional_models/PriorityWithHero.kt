package com.easyprog.data.storage.additional_models

import androidx.room.Embedded
import androidx.room.Relation
import com.easyprog.data.storage.additional_models.hero.HeroAvatar
import com.easyprog.data.storage.model.HeroesEntity
import com.easyprog.data.storage.model.PriorityHeroesEntity

data class PriorityWithHero(

    @Embedded
    val priority: PriorityHeroesEntity,

    @Relation(parentColumn = "id_hero", entityColumn = "idHero", entity = HeroesEntity::class)
    val heroAvatar: HeroAvatar?
)
