package com.android.smartyhome.local

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class AppPreferencesHelper @Inject
constructor(context: Context, @PreferenceInfo prefFileName: String) : PreferencesHelper {

    private val mPrefs: SharedPreferences =
        context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    override fun setUserName(userName: String?) {
        mPrefs.edit().putString(PREF_KEY_USER_NAME, userName).apply()
    }

    override fun getUserName(): String? =
        mPrefs.getString(PREF_KEY_USER_NAME, "")


    companion object {
        private const val PREF_KEY_USER_NAME = "PREF_KEY_USER_NAME"
    }
}