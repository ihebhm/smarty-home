package com.android.smartyhome.model

data class FadingSnackBarEvent(
    val longDuration: Boolean,
    val message: String,
    val success: Boolean=false
)