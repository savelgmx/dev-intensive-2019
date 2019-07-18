package ru.skillbranch.devintensive.devintensive2019.extensions

import ru.skillbranch.devintensive.devintensive2019.models.User
import ru.skillbranch.devintensive.devintensive2019.models.UserView
import ru.skillbranch.devintensive.devintensive2019.utils.Utils

/**
 * Created by Administrator on 18.07.2019.
 */
fun User.toUserView(): UserView {

    val nickName= Utils.transliteration("$firstName $lastName")
    val initials= Utils.toInitials(firstName, lastName)
    val status = if (lastVisit==null)"Ни разу не был" else if(isOnline) "online"
    else "Последний раз был ${lastVisit.humanizeDiff()}"

    return UserView(
            id,
            fullName = "$firstName $lastName",
            nickName = nickName,
            initials = initials,
            avatar = avatar,
            status = status
    )

}
