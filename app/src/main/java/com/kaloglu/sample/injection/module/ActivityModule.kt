package com.kaloglu.sample.injection.module

import android.app.Activity
import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.appcompat.app.AppCompatActivity
import com.kaloglu.sample.injection.qualifier.ActivityContext
import com.kaloglu.sample.injection.scopes.PerActivity
import com.kaloglu.sample.mobileui.base.BaseActivity
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
