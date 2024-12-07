package com.ad_coding.mvvmcourse.ui.screen.champion_list

import com.ad_coding.mvvmcourse.domain.model.ChampionModel

data class ChampionListState(
    val searchText: String = "",
    val champions: List<ChampionModel> = emptyList(),
    val filteredChampions: List<ChampionModel> = emptyList()
)
