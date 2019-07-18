package ru.skillbranch.devintensive.devintensive2019.models

/**
 * Created by Administrator on 18.07.2019.
 */
import ru.skillbranch.devintensive.devintensive2019.utils.Utils
import java.util.*

/**
 * Created by andrew on 29.06.2019.
 */
data class User(

        val id:String,
        var firstName:String?,
        var lastName:String?,
        var avatar:String?,
        var rating:Int=0,
        var respect:Int=0,
        val lastVisit:Date?=null,
        val isOnline:Boolean=false


) {

    constructor(id:String,firstName:String?,lastName:String?) : this(
            id=id,
            firstName=firstName,
            lastName=lastName,
            avatar =null
    )

    constructor(id: String):this(id,"firstName","Doe")

    init {

        println("it's alive And his name\n " +
                "${if (lastName==="Doe") "And His name $firstName $lastName"
                else "His name $firstName $lastName"}\n")

    }


    companion object Factory{
        private var lastId:Int=-1
        fun makeUser(fullName:String?): User {
            lastId++
            val(firstName,lastName)= Utils.parseFullName(fullName)


            return User(id = "${lastId}", firstName = firstName, lastName = lastName)
        }




    }
}