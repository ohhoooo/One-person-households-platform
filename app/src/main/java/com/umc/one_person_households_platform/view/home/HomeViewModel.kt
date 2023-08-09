package com.umc.one_person_households_platform.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umc.one_person_households_platform.model.GroupBuyingContent
import com.umc.one_person_households_platform.repository.home.HomeRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    private val _groupBuyingContent = MutableLiveData<List<GroupBuyingContent>>()
    val groupBuyingContent: LiveData<List<GroupBuyingContent>> = _groupBuyingContent

    init {
        loadGroupBuyingContent()
    }

    private fun loadGroupBuyingContent() {
        viewModelScope.launch {
            val getGroupBuyingContent = homeRepository.getGroupBuyingCategories()
            _groupBuyingContent.value = getGroupBuyingContent
        }
    }
}