package ru.skillbranch.devintensive.devintensive2019.utils

/**
 * Created by Administrator on 18.07.2019.
 */

/**
 * Created by andrew on 29.06.2019.
 */
object Utils{
    //TODO исправить поведение при передаче пустой строrи в параметре
    fun parseFullName(fullName:String?):Pair<String?,String?>{
        val parts:List<String>?=fullName?.split(" ")
        var firstName=parts?.getOrNull(0)
        var lastName=parts?.getOrNull(1)

        return firstName to lastName
    }


    fun convertRU(cyr: String): String {

        //транслитерация кирилического имени/фамилии в латиницу
        //сделана самым простым способом
        // silly but working

        var lat: String

        //Lower case letters
        lat = cyr.replace("а".toRegex(), "a")
        lat = lat.replace("б".toRegex(), "b")
        lat = lat.replace("в".toRegex(), "v")
        lat = lat.replace("г".toRegex(), "g")
        lat = lat.replace("д".toRegex(), "d")
        lat = lat.replace("е".toRegex(), "e")
        lat = lat.replace("ё".toRegex(), "e")
        lat = lat.replace("ж".toRegex(), "zh")
        lat = lat.replace("з".toRegex(), "z")
        lat = lat.replace("и".toRegex(), "i")
        lat = lat.replace("й".toRegex(), "i")
        lat = lat.replace("к".toRegex(), "k")
        lat = lat.replace("л".toRegex(), "l")
        lat = lat.replace("м".toRegex(), "m")
        lat = lat.replace("н".toRegex(), "n")
        lat = lat.replace("о".toRegex(), "o")
        lat = lat.replace("п".toRegex(), "p")
        lat = lat.replace("р".toRegex(), "r")
        lat = lat.replace("с".toRegex(), "s")
        lat = lat.replace("т".toRegex(), "t")
        lat = lat.replace("у".toRegex(), "u")
        lat = lat.replace("ф".toRegex(), "f")
        lat = lat.replace("х".toRegex(), "kh")
        lat = lat.replace("ц".toRegex(), "ts")
        lat = lat.replace("ч".toRegex(), "ch")
        lat = lat.replace("ш".toRegex(), "sh")
        lat = lat.replace("щ".toRegex(), "shch")
        lat = lat.replace("ъ".toRegex(), "ie")
        lat = lat.replace("ы".toRegex(), "y")
        lat = lat.replace("ь".toRegex(), "-")
        lat = lat.replace("э".toRegex(), "e")
        lat = lat.replace("ю".toRegex(), "iu")
        lat = lat.replace("я".toRegex(), "ia")

        //Capital letters
        lat = lat.replace("А".toRegex(), "A")
        lat = lat.replace("Б".toRegex(), "B")
        lat = lat.replace("В".toRegex(), "V")
        lat = lat.replace("Г".toRegex(), "G")
        lat = lat.replace("Д".toRegex(), "D")
        lat = lat.replace("Е".toRegex(), "E")
        lat = lat.replace("Ё".toRegex(), "E")
        lat = lat.replace("Ж".toRegex(), "ZH")
        lat = lat.replace("З".toRegex(), "Z")
        lat = lat.replace("И".toRegex(), "I")
        lat = lat.replace("Л".toRegex(), "L")
        lat = lat.replace("К".toRegex(), "K")
        lat = lat.replace("Л".toRegex(), "L")
        lat = lat.replace("М".toRegex(), "M")
        lat = lat.replace("Н".toRegex(), "N")
        lat = lat.replace("О".toRegex(), "O")
        lat = lat.replace("П".toRegex(), "P")
        lat = lat.replace("Р".toRegex(), "R")
        lat = lat.replace("С".toRegex(), "S")
        lat = lat.replace("Т".toRegex(), "T")
        lat = lat.replace("У".toRegex(), "U")
        lat = lat.replace("Ф".toRegex(), "F")
        lat = lat.replace("Х".toRegex(), "KH")
        lat = lat.replace("Ц".toRegex(), "TS")
        lat = lat.replace("Ч".toRegex(), "CH")
        lat = lat.replace("Ш".toRegex(), "SH")
        lat = lat.replace("Щ".toRegex(), "SHCH")
        lat = lat.replace("Ъ".toRegex(), "IE")
        lat = lat.replace("Ы".toRegex(), "Y")
        lat = lat.replace("Ь".toRegex(), "-")
        lat = lat.replace("Э".toRegex(), "E")
        lat = lat.replace("Ю".toRegex(), "IU")
        lat = lat.replace("Я".toRegex(), "IA")


        return lat //Return latinized string

    }


    fun transliteration(payload: String ,divider:String=" "): String? {
        // транслитерация кирилического имени/фамилии в латиницу
        //сделана самым простым способом
        // silly but working
        return convertRU(payload)

    }


    fun toInitials(firstName: String?, lastName: String?):String {

        var initialFirstName=firstName!!.substring(0,1)
        var initialLastName=lastName!!.substring(0,1)
        return "$initialFirstName"+"."+"$initialLastName"+"."
    }

}