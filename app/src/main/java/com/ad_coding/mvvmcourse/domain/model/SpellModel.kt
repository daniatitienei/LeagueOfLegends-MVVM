package com.ad_coding.mvvmcourse.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpellModel(
    @SerialName("description")
    val description: String? = "",
    @SerialName("id")
    val id: String? = "",
    @SerialName("image")
    val image: ImageModel? = ImageModel(),
    @SerialName("name")
    val name: String? = ""
)