package com.ad_coding.mvvmcourse.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChampionModel(
    @SerialName("id")
    val id: String? = "",
    @SerialName("image")
    val image: ImageModel? = ImageModel(),
    @SerialName("key")
    val key: String? = "",
    @SerialName("lore")
    val lore: String? = "",
    @SerialName("blurb")
    val blurb: String? = "",
    @SerialName("name")
    val name: String? = "",
    @SerialName("passive")
    val passive: PassiveModel? = PassiveModel(),
    @SerialName("spells")
    val spells: List<SpellModel> = listOf(),
    @SerialName("tags")
    val tags: List<String> = listOf(),
    @SerialName("title")
    val title: String? = ""
)