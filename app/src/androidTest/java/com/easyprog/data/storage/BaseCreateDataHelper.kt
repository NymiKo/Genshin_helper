package com.easyprog.data.storage

abstract class BaseCreateDataHelper {

    fun <T> createData(count: Int, entity: T): List<T> {
        val listArtifacts = mutableListOf<T>()
        for (i in 1..count) {
            listArtifacts.add(entity)
        }
        return listArtifacts
    }

}