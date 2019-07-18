package ru.skillbranch.devintensive.devintensive2019.models

/**
 * Created by Administrator on 18.07.2019.
 */

/**
 * Created by andrew on 01.07.2019.
 */
class Chat(
        val id: String,
        val members:MutableList<User> = mutableListOf(),
        val messages:MutableList<BaseMessage> = mutableListOf()
)
{
}