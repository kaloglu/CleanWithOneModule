package com.kaloglu.sample.presentation.interfaces.splash

import android.content.Intent
import com.kaloglu.sample.presentation.interfaces.activity.mvp.ActivityPresenter
import com.kaloglu.sample.presentation.interfaces.activity.mvp.ActivityView

interface SplashContract {

    interface View : ActivityView {
        fun handleSignInResult(data: Intent?, resultCode: Int)
    }

    interface Presenter : ActivityPresenter<View> {
        fun getNextActivity()
        fun getSignInActivity()
        fun checkAuth()
    }
}
