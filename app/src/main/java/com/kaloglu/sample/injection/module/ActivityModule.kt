package com.kaloglu.sample.injection.module

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.kaloglu.sample.injection.qualifier.ActivityContext
import com.kaloglu.sample.injection.scopes.PerActivity
import com.kaloglu.sample.mobileui.base.BaseActivity
import com.kaloglu.sample.navigation.FragmentNavigator
import com.kaloglu.sample.presentation.interfaces.base.navigator.BaseFragmentNavigator
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ActivityModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        @PerActivity
        fun fragmentNavigator(fragmentManager: FragmentManager): FragmentNavigator =
                BaseFragmentNavigator(fragmentManager)

        @JvmStatic
        @Provides
        @PerActivity
        fun provideFragmentManager(activity: AppCompatActivity): FragmentManager =
                activity.supportFragmentManager

    }

    @Binds
    @PerActivity
    abstract fun bindAppCompatActivity(activity: BaseActivity): AppCompatActivity

    @Binds
    @PerActivity
    abstract fun bindActivity(activity: AppCompatActivity): Activity

    @ActivityContext
    @Binds
    @PerActivity
    abstract fun bindActivityContext(activity: Activity): Context
}
