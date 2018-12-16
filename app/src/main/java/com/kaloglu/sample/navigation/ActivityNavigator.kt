package com.kaloglu.sample.navigation

import android.app.Activity
import android.content.Intent
import android.net.Uri
import com.firebase.ui.auth.AuthUI
import com.kaloglu.sample.BuildConfig
import com.kaloglu.sample.injection.scopes.PerActivity
import com.kaloglu.sample.mobileui.main.MainActivity
import com.kaloglu.sample.mobileui.splash.SplashActivity
import java.util.*
import javax.inject.Inject

@PerActivity
class ActivityNavigator @Inject constructor(private val activity: Activity) {

    fun finishCurrentActivity() =
            NavigationCreator(activity)
                    .finishThis()

    fun openExternalUrl(url: String) =
            NavigationCreator(activity)
                    .intent(Intent(Intent.ACTION_VIEW, Uri.parse(url)))

    fun toMainActivity() =
            NavigationCreator(activity)
                    .intent(MainActivity.newIntent(activity))

    fun toSignInActivity(requestCodeForSignIn: Int): NavigationCreator {

        val providerList =
                Arrays.asList(
                        AuthUI.IdpConfig.GoogleBuilder().build(),
                        AuthUI.IdpConfig.EmailBuilder().build(),
                        AuthUI.IdpConfig.PhoneBuilder().build(),
                        AuthUI.IdpConfig.AnonymousBuilder().build()
                )

        val intent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setIsSmartLockEnabled(!BuildConfig.DEBUG, true)
                .setAvailableProviders(providerList)
                .build()

        return NavigationCreator(activity)
                .intent(intent)
                .forResult(requestCodeForSignIn)
    }

    fun toSplashScreen() =
            NavigationCreator(activity)
                    .intent(SplashActivity.newIntent(activity))

}
