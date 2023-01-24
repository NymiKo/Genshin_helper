package com.easyprog.genshin.fragments.artifacts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.easyprog.genshin.R
import com.easyprog.genshin.model.Artifacts

class ArtifactsViewModel : ViewModel() {

    private val _artifactsList = MutableLiveData<List<Artifacts>>()
    val artifactsList: LiveData<List<Artifacts>> = _artifactsList

    init {
        getData()
    }

    private fun getData() {
        _artifactsList.postValue(createArtifactsData())
    }

    private fun createArtifactsData(): List<Artifacts> {

        val mockData: MutableList<Artifacts> = ArrayList()
        mockData.add(
            Artifacts(
                0,
                "Кокон сладких грёз",
                "Пора расцвета",
                R.drawable.artifacts_cocoon_flower,
                "Перо чертога",
                R.drawable.artifacts_cocoon_stylus,
                "Песнь жизни",
                R.drawable.artifacts_cocoon_watch,
                "Тыква пробуждения",
                R.drawable.artifacts_cocoon_cup,
                "Шляпа телесности",
                R.drawable.artifacts_cocoon_cap
            )
        )
        mockData.add(
            Artifacts(
                1,
                "Стойкость Миллелита",
                "Цветок почестей",
                R.drawable.artifacts_millelite_flower,
                "Боевое перо командира",
                R.drawable.artifacts_millelite_stylus,
                "Золотые часы",
                R.drawable.artifacts_millelite_watch,
                "Золотой кубок клятвы",
                R.drawable.artifacts_millelite_cup,
                "Древний шлем генерала",
                R.drawable.artifacts_millelite_cap
            )
        )
        mockData.add(
            Artifacts(
                2,
                "Киноварное загробье",
                "Цветение жизни",
                R.drawable.artifacts_cinnabar_tomb_flower,
                "Перо скрытого сияния",
                R.drawable.artifacts_cinnabar_tomb_stylus,
                "Солнечная реликвия",
                R.drawable.artifacts_cinnabar_tomb_watch,
                "Мгновение договора",
                R.drawable.artifacts_cinnabar_tomb_cup,
                "Громогласный облик",
                R.drawable.artifacts_cinnabar_tomb_cap
            )
        )

        return mockData
    }
}