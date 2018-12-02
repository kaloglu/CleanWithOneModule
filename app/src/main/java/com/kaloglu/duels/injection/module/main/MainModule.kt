package com.kaloglu.duels.injection.module.main

import com.kaloglu.duels.domain.interfaces.main.MainContract
import com.kaloglu.duels.domain.main.MainPresenter
import com.kaloglu.duels.injection.module.ActivityModule
import com.kaloglu.duels.injection.scopes.PerActivity
import com.kaloglu.duels.mobileui.base.BaseActivity
import com.kaloglu.duels.mobileui.main.MainActivity
import com.kaloglu.duels.navigation.ActivityNavigator
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [ActivityModule::class])
abstract class MainModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        @PerActivity
        fun presenter(activityNavigator: ActivityNavigator): MainContract.Presenter =
                MainPresenter(activityNavigator)

    }

    @Binds
    @PerActivity
    abstract fun main(activity: MainActivity): BaseActivity

}
