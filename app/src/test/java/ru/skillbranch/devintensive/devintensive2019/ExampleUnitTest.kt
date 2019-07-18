package ru.skillbranch.devintensive.devintensive2019

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.devintensive2019.extensions.TimeUnits
import ru.skillbranch.devintensive.devintensive2019.extensions.add
import ru.skillbranch.devintensive.devintensive2019.extensions.format
import ru.skillbranch.devintensive.devintensive2019.extensions.toUserView
import ru.skillbranch.devintensive.devintensive2019.models.BaseMessage
import ru.skillbranch.devintensive.devintensive2019.models.Chat
import ru.skillbranch.devintensive.devintensive2019.models.User
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance(){
        val user= User("1")
        val user2= User("2", "John", "Cena")
        val user3= User("3")
        println("$user")
    }
    @Test
    fun test_factory(){
        val user= User.makeUser("John Cena")
        val user2= user.copy(id="2",lastName="Snow",lastVisit = Date())
        print("$user \n $user2")

    }
    @Test
    fun test_decomposition(){
        val user = User.makeUser("Jon Weak")
        fun getUserInfo()=user
        val(id,firstName,lastName)=getUserInfo()
        println("$id,$firstName,$lastName")
        println("${user.component1()},${user.component2()},${user.component3()}")
    }

    @Test
    fun test_copy(){
        val user= User.makeUser("Jon Snow")
        var user2=user.copy(lastVisit = Date())
        var user3=user.copy(lastVisit = Date().add(2, TimeUnits.SECOND))
        var user4=user.copy(lastVisit = Date().add(2, TimeUnits.HOUR))

        println("""
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
            ${user4.lastVisit?.format()}
        """.trimIndent())
    }
    @Test
    fun dataq_maping(){
        val user= User.makeUser("Jon Snow")
        val newUser=user.copy(lastVisit = Date().add(-7, TimeUnits.DAY))
        println(user)
        val userView=newUser.toUserView()
        userView.printMe()
    }
    @Test
    fun test_abstarct_factory(){
        val user= User.makeUser("Jon Snow")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"),payload = "any text message",type = "text")
        val imgMessage = BaseMessage.makeMessage(user, Chat("0"),payload = "any image url",type = "image")

        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())
    }
    @Test
    fun test_transliteration(){
        val user= User.makeUser("Тирион Ланнистер")
        println(user)
        val userView=user.toUserView()
        userView.printMe()
    }
    @Test
    fun test_of_BaseMessage_AbstractFactory(){

        val vasya = User("0", "Василий", null)

        val msg_1 = BaseMessage.makeMessage(vasya,
                Chat("0"),
                Date(),
                "text",
                "any text message")
        val msg_2 = BaseMessage.makeMessage(vasya,
                Chat("1"),
                Date().add(-2, TimeUnits.HOUR),
                "image",
                "https://anyurl.com")

        //       assertEquals("id:0 Василий отправил сообщение \"any text message\" только что", msg_1.formatMessage())
        //     assertEquals("id:1 Василий получил изображение \"https://anyurl.com\" 2 часа назад", msg_2.formatMessage())
    }
}
