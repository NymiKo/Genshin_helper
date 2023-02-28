package com.easyprog.data.storage.additional_models

import androidx.room.Embedded
import androidx.room.Relation
import com.easyprog.data.storage.additional_models.hero.HeroAvatar
import com.easyprog.data.storage.entities.HeroesEntity
import com.easyprog.data.storage.entities.PriorityHeroesEntity

data class PriorityWithHero(

    @Embedded
    val priority: PriorityHeroesEntity,

    @Relation(parentColumn = "hero_id", entityColumn = "id", entity = HeroesEntity::class)
    val heroAvatar: HeroAvatar
)
