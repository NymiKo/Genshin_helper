package com.easyprog.genshin.fragments.heroes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.easyprog.genshin.R
import com.easyprog.genshin.model.Heroes

class HeroesViewModel : ViewModel() {

    private val _heroesList = MutableLiveData<List<Heroes>>()
    val heroesList: LiveData<List<Heroes>> = _heroesList

    init {
        getData()
    }

    private fun getData() {
        _heroesList.value = createHeroesData()
    }

    private fun createHeroesData(): List<Heroes> {
        val mockData: MutableList<Heroes> = ArrayList()
        mockData.add(Heroes(0, "Итто", R.drawable.itto))
        mockData.add(Heroes(1, "Чжун Ли", R.drawable.zhongli))
        mockData.add(Heroes(2, "Венти", R.drawable.venti))
        mockData.add(Heroes(3, "Сяо", R.drawable.xiao))
        mockData.add(Heroes(4, "Дилюк", R.drawable.diluc))

        return mockData
    }

}