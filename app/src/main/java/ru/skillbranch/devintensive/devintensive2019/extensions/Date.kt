package ru.skillbranch.devintensive.devintensive2019.extensions

/**
 * Created by Administrator on 18.07.2019.
 */

import android.annotation.TargetApi
import android.os.Build
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Period
import java.util.*

/**
 * Created by andrew on 30.06.2019.
 */

const val SECOND=1000L
const val MINUTE=60* SECOND
const val HOUR=60* MINUTE
const val DAY=24* HOUR

fun Date.format(pattern:String="HH:mm:ss dd.MM.yy"):String {
    val dataFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dataFormat.format(this)
}
fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND):Date {

    var time =this.time
    time+= when(units){
        TimeUnits.SECOND ->value* SECOND
        TimeUnits.MINUTE ->value* MINUTE
        TimeUnits.HOUR ->value* HOUR
        TimeUnits.DAY ->value* DAY
    }
    this.time=time
    return this

}
enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY
}
@TargetApi(Build.VERSION_CODES.O)
fun Date.humanizeDiff(date: Date=Date()): String {
    // must return difference between user lastVisited time  and current Time(?)

    var dateFormat = SimpleDateFormat("YYYY-MM-dd")
    var hoursFormat = SimpleDateFormat("hh")
    var minitesFormat = SimpleDateFormat("mm")

    var lastVisitedDate =   LocalDate.parse(dateFormat.format(date))
    var currentDate     =   LocalDate.parse(dateFormat.format(Date()))
    var period = Period.between(lastVisitedDate, currentDate) //используем Kotlin period который может вернуть разницу между двумя датами
    // период разница в годах месяцах и днях


    var lastVisitedHour=(hoursFormat.format(date.time).toInt())
    var currentHour=(hoursFormat.format(Date().time).toInt())

    var lastVisitedMinutes=(hoursFormat.format(date.time).toInt())
    var currentMinutes=(hoursFormat.format(Date().time).toInt())

    var hourDifference =lastVisitedHour-currentHour //разница в часах между текущим временем и временем последнего посещения пользвателя
    var minutesDifference =lastVisitedMinutes-currentMinutes //разница в минутах между текущим временем и временем последнего посещения пользвателя

    var result=" "

    if(period.years>0){
        result=result+" ${period.years} лет тому вперед.Изобрели машину времени?"
    }
    else if(period.years<0){
        result=result+" ${period.years}лет тому назад."
    }

    if(period.months>0){
        result=result+" ${period.months} месяцев тому вперед.Изобрели машину времени?"
    }
    else if(period.months<0){
        result=result+" ${period.months}месяцев тому назад. "
    }

    if(period.days>0){
        result=result+" ${period.days} дней тому вперед.Изобрели машину времени?"
    }
    else if(period.days<0){
        result=result+" ${period.days}день тому назад. "
    }

    if (hourDifference>0){
        result=result+" ${hourDifference}часов тому вперед.Проверьте системное время!"
    }else if(hourDifference<0){result=result+" ${hourDifference}часов тому назад "}

    if (minutesDifference>0){
        result=result+" ${minutesDifference}минут тому вперед.Проверьте системное время!"
    }else if(minutesDifference<0){result=result+" ${minutesDifference}минут тому назад "
    }else if(minutesDifference<5){result="только что"}



    return result
}
