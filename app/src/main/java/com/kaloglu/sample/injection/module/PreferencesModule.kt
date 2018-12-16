package com.kaloglu.sample.injection.module

import android.app.Application
import com.kaloglu.sample.data.LocalStorage
import com.kaloglu.sample.injection.scopes.PerApplication
import dagger.Module
import dagger.Provides

@Module
class PreferencesModule {
    @Module
    companion object {

        @JvmStatic
        @PerApplication
        @Provides
        fun providesLocalStorage(application: Application): LocalStorage =
                LocalStorage(application)
    }
}
