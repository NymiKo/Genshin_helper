package com.easyprog.genshin.model

data class Hero(
    val id: Int,
    val name: String,
    val avatar: Int,
    val birthday: String,
    val element: String,
    val region: String,
    val talentMaterialId: Int?
)