package com.kaloglu.sample.injection.module.splash

import com.google.firebase.auth.FirebaseAuth
import com.kaloglu.sample.injection.module.ActivityModule
import com.kaloglu.sample.injection.scopes.PerActivity
import com.kaloglu.sample.mobileui.base.BaseActivity
import com.kaloglu.sample.mobileui.splash.SplashActivity
import com.kaloglu.sample.navigation.ActivityNavigator
import com.kaloglu.sample.presentation.interfaces.splash.SplashContract
import com.kaloglu.sample.presentation.splash.SplashPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [ActivityModule::class])
abstract class SplashModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        @PerActivity
        fun presenter(
                firebaseAuth: FirebaseAuth,
                activityNavigator: ActivityNavigator
        ): SplashContract.Presenter =
                SplashPresenter(firebaseAuth, activityNavigator)

    }

    @Binds
    @PerActivity
    abstract fun main(activity: SplashActivity): BaseActivity

}
