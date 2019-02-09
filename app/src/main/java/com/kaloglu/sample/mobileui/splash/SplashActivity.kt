package com.kaloglu.sample.mobileui.splash

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Handler
import com.firebase.ui.auth.IdpResponse
import com.kaloglu.sample.R
import com.kaloglu.sample.mobileui.base.mvp.BaseMvpActivity
import com.kaloglu.sample.presentation.interfaces.splash.SplashContract
import com.kaloglu.sample.viewobjects.CachedSample

class SplashActivity : BaseMvpActivity<CachedSample, SplashContract.Presenter>(), SplashContract.View<CachedSample> {

    override val contentResourceId = R.layout.activity_splash

    override val baseFrameLayoutId = R.id.sign_in_container

    override fun initUserInterface() = Unit

    override fun onLoading() = showSnackbar("loading")

    override fun onSuccess(data: CachedSample?) = presenter.getNextActivity()

    override fun onError(errorMessage: String?, data: CachedSample?) =
            showSnackbar("hata: $errorMessage").also {
                Handler().postDelayed(presenter::getSignInActivity, 1000)
            }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) =
            super.onActivityResult(requestCode, resultCode, data)
                    .also {
                        when (requestCode) {
                            presenter.requestCodeForSignIn -> handleSignInResult(IdpResponse.fromResultIntent(data), resultCode)
                        }
                    }

    override fun handleSignInResult(data: Intent?, resultCode: Int) =
            when (resultCode) {
                Activity.RESULT_OK -> presenter.checkAuth()
                else -> finish()

    override fun onPresenterAttached() = presenter.checkAuth()

    companion object {

        @JvmStatic
        fun newIntent(context: Context): Intent = Intent(context, SplashActivity::class.java)

    }
}
