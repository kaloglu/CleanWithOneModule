package com.kaloglu.sample.mobileui.base.mvp

import androidx.annotation.CallSuper
import com.google.android.gms.tasks.OnCompleteListener
import com.kaloglu.sample.mobileui.base.BaseFragment
import com.kaloglu.sample.presentation.base.GenericDependencies
import com.kaloglu.sample.presentation.interfaces.base.mvp.BasePresenter
import com.kaloglu.sample.presentation.interfaces.base.mvp.BaseView
import com.kaloglu.sample.utils.checkInjection
import java.lang.ref.WeakReference

abstract class BaseAbstractPresenter<V : BaseView> : BasePresenter<V> {

    override val genericDependencies: GenericDependencies? = null
        get() = GenericDependencies::class.java.checkInjection(field)

    private var viewRef: WeakReference<V>? = null

    @CallSuper
    @Suppress("UNCHECKED_CAST")
    override fun attachView(view: BaseView) {
        viewRef = WeakReference(view as V)
    }

    @CallSuper
    override fun attachLifecycle() =
            getLifeCycle().addObserver(this)

    @CallSuper
    override fun detachLifecycle() =
            getLifeCycle().removeObserver(this)

    @CallSuper
    override fun detachView() {
        viewRef?.clear()
        viewRef = null
    }

    override fun getView() = when {
        isViewAttached() -> viewRef!!.get()!!
        else -> throw IllegalArgumentException()
    }

    override fun isViewAttached() = viewRef != null && viewRef?.get() != null

    override fun getLifeCycle() = getView().lifecycle

    override fun signOut(): OnCompleteListener<Void> =
            OnCompleteListener {
                genericDependencies!!
                        .activityNavigator
                        .toSplashScreen()
                        .finishThis()
                        .navigate()
            }

    override fun getNextActivity() {
        TODO("getNextActivity() not implemented at ${this.javaClass.name}")
    }

    override fun getSignInActivity() {
        activityNavigator
                .toSignInActivity(requestCodeForSignIn)
                .navigate()
    }

    override fun showFragment(fragment: BaseFragment?) {
        fragment?.let {
            fragmentNavigator
                    .showFragment(fragment)
        }
    }

}
