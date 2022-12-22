package com.easyprog.genshin.fragments.purposes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.easyprog.data.storage.additional_models.PriorityWithHero
import com.easyprog.domain.repositories.PurposeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PurposesViewModel @Inject constructor(private val repositoryPurpose: PurposeRepository) : ViewModel() {

    fun getPurposesHeroes(): LiveData<List<PriorityWithHero>> {
        return repositoryPurpose.getPriorityWithHeroesList()
    }

}