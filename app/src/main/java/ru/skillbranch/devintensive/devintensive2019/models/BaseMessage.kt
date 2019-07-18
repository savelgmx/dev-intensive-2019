package ru.skillbranch.devintensive.devintensive2019.models

/**
 * Created by Administrator on 18.07.2019.
 */
import java.util.*

/**
 * Created by andrew on 01.07.2019.
 */
abstract class BaseMessage(
        val id:String,
        val from: User?,
        val chat: Chat,
        val isIncoming:Boolean=false,
        val date: Date= Date()
) {

    abstract fun formatMessage():String
    companion object AbstractFactory{
        var lastId = -1;
        fun makeMessage(from: User?, chat: Chat, date: Date=Date(), type: String="text", payload: Any?): BaseMessage {
            lastId++
            return when(type){
                "image"-> ImageMessage("${lastId}", from, chat, date = date, image = payload as String)
                else-> TextMessage("${lastId}", from, chat, date = date, text = payload as String)

            }
        }

    }
}