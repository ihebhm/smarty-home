package com.android.smartyhome.dataManager


import com.android.smartyhome.local.PreferencesHelper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDataManager @Inject
constructor(
    private val mPreferencesHelper: PreferencesHelper
) : DataManager {


    override fun setUserName(userName: String?) {
        mPreferencesHelper.setUserName(userName)
    }

    override fun getUserName(): String? {
        return mPreferencesHelper.getUserName()
    }

}
