package ru.skillbranch.devintensive.devintensive2019.models

/**
 * Created by Administrator on 18.07.2019.
 */
import ru.skillbranch.devintensive.devintensive2019.extensions.humanizeDiff
import java.util.*

/**
 * Created by andrew on 01.07.2019.
 */
class TextMessage(
        id:String,
        from: User?,
        chat: Chat,
        isIncoming:Boolean=false,
        date: Date = Date(),
        var text: String
): BaseMessage(id,from,chat,isIncoming,date) {
    override fun formatMessage(): String="id: $id ${from?.firstName} " +
            "${if(isIncoming)"got message" else "sent"} message \" $text\" ${date.humanizeDiff()}"

}