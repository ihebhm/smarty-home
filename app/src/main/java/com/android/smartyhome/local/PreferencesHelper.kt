package com.android.smartyhome.local


interface PreferencesHelper {

    fun getUserName(): String?
    fun setUserName(userName: String?)
}