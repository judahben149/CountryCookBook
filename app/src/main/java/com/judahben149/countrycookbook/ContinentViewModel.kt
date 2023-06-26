package com.judahben149.countrycookbook

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.judahben149.countrycookbook.data.repository.MainRepository
import com.judahben149.countrycookbook.domain.model.Continent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContinentViewModel @Inject constructor(private val mainRepository: MainRepository): ViewModel() {

    var continentList: MutableLiveData<List<Continent>> = MutableLiveData(emptyList())

    init {
        getContinentList()
    }

    fun getContinentList() {
        viewModelScope.launch {
            continentList.value = mainRepository.getContinentList()
        }
    }
}