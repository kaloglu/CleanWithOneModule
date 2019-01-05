package com.kaloglu.sample.injection.module.main

import com.kaloglu.sample.mobileui.demo.DemoFragment
import com.kaloglu.sample.data.LocalStorage
import com.kaloglu.sample.injection.module.ActivityModule
import com.kaloglu.sample.injection.scopes.PerActivity
import com.kaloglu.sample.injection.scopes.PerFragment
import com.kaloglu.sample.mobileui.base.BaseActivity
import com.kaloglu.sample.mobileui.main.MainActivity
import com.kaloglu.sample.navigation.ActivityNavigator
import com.kaloglu.sample.presentation.interfaces.main.MainContract
import com.kaloglu.sample.presentation.main.MainPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module(includes = [ActivityModule::class])
abstract class MainModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        @PerActivity
        fun presenter(
                localStorage: LocalStorage,
                activityNavigator: ActivityNavigator
        ): MainContract.Presenter =
                MainPresenter(localStorage, activityNavigator)

    }

    @Binds
    @PerActivity
    abstract fun main(activity: MainActivity): BaseActivity

    @PerFragment
    @ContributesAndroidInjector()
    abstract fun contributesDemoFragment(): DemoFragment

}
