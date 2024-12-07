package com.ad_coding.mvvmcourse.ui.screen.champion_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ad_coding.mvvmcourse.domain.model.toChampionList
import com.ad_coding.mvvmcourse.domain.repository.ApiRepository
import com.skydoves.sandwich.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChampionListViewModel @Inject constructor(
    private val apiRepository: ApiRepository
) : ViewModel() {

    private val _state = MutableStateFlow(ChampionListState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            apiRepository.getAllChampions()
                .onSuccess {
                    _state.update {
                        it.copy(
                            champions = data.champion.toChampionList()
                        )
                    }
                }
        }
    }

    fun onSearchTextChange(text: String) {
        _state.update {
            it.copy(
                searchText = text,
                filteredChampions = it.champions.filter { champion ->
                    champion.name?.contains(text, ignoreCase = true) == true
                }
            )
        }
    }
}