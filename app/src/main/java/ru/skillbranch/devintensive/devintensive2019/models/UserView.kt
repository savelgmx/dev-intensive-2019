package ru.skillbranch.devintensive.devintensive2019.models

/**
 * Created by Administrator on 18.07.2019.
 */
/**
 * Created by andrew on 30.06.2019.
 */
class UserView(
        val id:String,
        var fullName:String?,
        var nickName:String?,
        var avatar:String?,
        var status:String?="offline",
        val initials:String? = null
)
{

    fun printMe() {
        println("""
        id:$id
        fullName:$fullName:
        nickName:$nickName:
        avatar:$avatar:
        status:$status:
        initials:$initials:

        """.trimIndent())
    }
}