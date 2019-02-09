package com.kaloglu.sample.presentation.main

import com.google.android.gms.tasks.OnCompleteListener
import com.kaloglu.sample.data.LocalStorage
import com.kaloglu.sample.mobileui.base.mvp.ActivityAbstractPresenter
import com.kaloglu.sample.navigation.ActivityNavigator
import com.kaloglu.sample.presentation.interfaces.main.MainContract
import javax.inject.Inject

class MainPresenter @Inject constructor(
        private val localStorage: LocalStorage,
        activityNavigator: ActivityNavigator
) : ActivityAbstractPresenter<MainContract.View>(), MainContract.Presenter {

    override fun getNextActivity() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun signOut(): OnCompleteListener<Void> =
            OnCompleteListener {
                localStorage.cleaSample()
                activityNavigator
                        .toSplashScreen()
                        .finishThis()
                        .navigate()
            }
}
