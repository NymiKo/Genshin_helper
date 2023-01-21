package com.easyprog.data.storage.contract

class RoomContract {

    companion object {

        const val databaseApp = "Genshin.db"

        const val tableHeroes = "heroes"
        const val tablePriorityHeroes = "priority"
        const val tableMaterialTalents = "materials_talents"
        const val tableDungeonsTalentsMaterial = "dungeons_talents_material"
        const val tableArtifacts = "artifacts"
        const val tableWeapon = "weapon"
        const val tableMaterialsWeapons = "materials_weapons"
        const val tableDungeonsWeaponMaterial = "dungeons_weapon_material"
        const val tableBuildsHeroesArtifacts = "builds_heroes_artifacts"
        const val tableBuildsHeroesWeapons = "builds_heroes_weapons"
        const val tableDungeonsTalentsMaterialByDay = "dungeons_talents_material_by_day"
        const val tableDungeonsWeaponMaterialByDay = "dungeons_weapon_material_by_day"
    }
}