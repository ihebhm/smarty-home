package com.android.smartyhome.local

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class PreferenceModule {

    @Provides
    @PreferenceInfo
    internal fun providerprefFileName(): String = "PREF_NAME"

    @Provides
    @Singleton
    internal fun providerPreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }
}
