package com.ad_coding.mvvmcourse.domain.repository

import com.ad_coding.mvvmcourse.domain.model.ChampionResponseModel
import com.skydoves.sandwich.ApiResponse

interface ApiRepository {

    suspend fun getAllChampions(): ApiResponse<ChampionResponseModel>

    suspend fun getChampionByName(name: String): ApiResponse<ChampionResponseModel>
}