package com.kaloglu.sample.injection

import android.app.Application
import com.kaloglu.sample.SampleApp
import com.kaloglu.sample.injection.firestore.FirestoreModule
import com.kaloglu.sample.injection.module.ActivityBindingModule
import com.kaloglu.sample.injection.module.ApplicationModule
import com.kaloglu.sample.injection.module.PreferencesModule
import com.kaloglu.sample.injection.module.data.DataModule
import com.kaloglu.sample.injection.module.data.cache.CacheModule
import com.kaloglu.sample.injection.module.data.remote.RemoteModule
import com.kaloglu.sample.injection.scopes.PerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApplicationModule::class,
    PreferencesModule::class,
    ActivityBindingModule::class,
    DataModule::class,
    CacheModule::class,
    RemoteModule::class,
    FirestoreModule::class
])
interface ApplicationComponent : AndroidInjector<SampleApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    override fun inject(sampleApp: SampleApp)

}
