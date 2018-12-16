package com.kaloglu.sample.injection.module

import com.kaloglu.sample.injection.module.main.MainModule
import com.kaloglu.sample.injection.module.splash.SplashModule
import com.kaloglu.sample.injection.scopes.PerActivity
import com.kaloglu.sample.mobileui.main.MainActivity
import com.kaloglu.sample.mobileui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [ActivityModule::class])
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [SplashModule::class])
    abstract fun contributesSplashActivity(): SplashActivity


    @PerActivity
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun contributesMainActivity(): MainActivity

}
