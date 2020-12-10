package com.android.smartyhome.ui.adapters

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.android.smartyhome.R
import kotlinx.coroutines.ExperimentalCoroutinesApi

@SuppressLint("SetTextI18n")
@ExperimentalCoroutinesApi
@BindingAdapter("textInt")
fun textInt(
    textView: TextView,
    number: Int,
) {
    textView.text = "$number " + if (number == 1) {
        textView.context.getString(R.string.device)
    } else {
        textView.context.getString(R.string.devices)
    }

}