package com.android.smartyhome.utils

import android.annotation.SuppressLint
import androidx.navigation.NavOptions
import com.android.smartyhome.R
import java.text.SimpleDateFormat
import java.util.*

fun getNavOptions(): NavOptions {

    return NavOptions.Builder()
        .setEnterAnim(R.anim.slide_in_right)
        .setExitAnim(R.anim.slide_out_left)
        .setPopEnterAnim(R.anim.slide_in_left)
        .setPopExitAnim(R.anim.slide_out_right)
        .build()
}

/**
 * format date from [Calendar] to string
 */
@SuppressLint("SimpleDateFormat")
fun getDateFormat(calendar: Calendar?): String {
    calendar?.let { mCalendar ->
        val sdf = SimpleDateFormat("MMMM dd,yyyy")
        return sdf.format(mCalendar.time)
    }
    return ""
}