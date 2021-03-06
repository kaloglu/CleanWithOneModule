package com.kaloglu.sample.presentation.splash

import com.firebase.ui.auth.ErrorCodes
import com.firebase.ui.auth.FirebaseUiException
import com.google.firebase.auth.FirebaseAuth
import com.kaloglu.sample.R
import com.kaloglu.sample.mobileui.base.mvp.ActivityAbstractPresenter
import com.kaloglu.sample.presentation.base.GenericDependencies
import com.kaloglu.sample.presentation.interfaces.splash.SplashContract
import javax.inject.Inject

class SplashPresenter @Inject constructor(
        private val firebaseAuth: FirebaseAuth,
        override val genericDependencies: GenericDependencies
) : ActivityAbstractPresenter<SplashContract.View>(), SplashContract.Presenter {

    override fun checkAuth() =
            when {
                firebaseAuth.currentUser == null -> getSignInActivity()
                else -> getNextActivity()
            }

    override fun getNextActivity() =
            activityNavigator.toMainActivity()
                    .singleTop()
                    .clearTop()
                    .finishThis()
                    .navigate()

    override fun showError(firebaseUiException: FirebaseUiException) =
            getView().showSnackbar(
                    when (firebaseUiException.errorCode) {
                        ErrorCodes.UNKNOWN_ERROR -> R.string.unknown_error
                        ErrorCodes.NO_NETWORK -> R.string.no_internet_connection
                        ErrorCodes.PLAY_SERVICES_UPDATE_CANCELLED -> R.string.common_google_play_services_updating_text
                        ErrorCodes.DEVELOPER_ERROR -> R.string.developer_error
                        ErrorCodes.PROVIDER_ERROR -> R.string.provider_error
                        ErrorCodes.ANONYMOUS_UPGRADE_MERGE_CONFLICT -> R.string.anonymous_upgrade_merge_error
                        ErrorCodes.EMAIL_MISMATCH_ERROR -> R.string.email_mismatch_error
                        else -> R.string.unknown_sign_in_response
                    }
            )
}



