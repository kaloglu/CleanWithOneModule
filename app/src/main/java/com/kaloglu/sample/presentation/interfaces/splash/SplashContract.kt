package com.kaloglu.sample.presentation.interfaces.splash

import com.firebase.ui.auth.FirebaseUiException
import com.kaloglu.sample.presentation.interfaces.base.mvp.BasePresenter
import com.kaloglu.sample.presentation.interfaces.base.mvp.BaseView
import com.kaloglu.sample.viewobjects.CachedSample

interface SplashContract {

    interface View<M> : BaseView<M>

    interface Presenter : BasePresenter<CachedSample, View<CachedSample>> {
        fun checkAuth()
        fun showError(error: FirebaseUiException)
    }
}
