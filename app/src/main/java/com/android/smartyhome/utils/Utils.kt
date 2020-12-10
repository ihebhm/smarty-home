package com.android.smartyhome.utils

import androidx.navigation.NavOptions
import com.android.smartyhome.R

fun getNavOptions(): NavOptions {

    return NavOptions.Builder()
        .setEnterAnim(R.animator.slide_in_right)
        .setExitAnim(R.animator.slide_out_left)
        .setPopEnterAnim(R.animator.slide_in_left)
        .setPopExitAnim(R.animator.slide_out_right)
        .build()
}