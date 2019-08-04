package ru.skillbranch.devintensive.devintensive2019.models

data class Profile(
        val firstName:String,
        val lastName:String,
        val about:String,
        val repository:String,
        val rating:Int=0,
        val respect:Int=0
) {
    val nickname:String="Jon Doe "//TODO implement me
    val rank:String="Junior Android Developer"


    fun toMap():Map<String,Any> = mapOf(
        "nickname" to nickname,
        "rank" to rank,
        "firstName" to firstName,
        "lastName" to lastName,
        "about" to about,
        "repository" to repository,
        "rating" to rating,
        "respect" to respect
    )

}