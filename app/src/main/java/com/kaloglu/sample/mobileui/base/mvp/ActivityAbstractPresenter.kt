package com.kaloglu.sample.mobileui.base.mvp

import android.os.Bundle
import com.kaloglu.sample.mobileui.base.BaseFragment
import com.kaloglu.sample.presentation.interfaces.activity.mvp.ActivityPresenter
import com.kaloglu.sample.presentation.interfaces.activity.mvp.ActivityView

abstract class ActivityAbstractPresenter<V : ActivityView> : BaseAbstractPresenter<V>(), ActivityPresenter<V> {

    override fun showInitialFragment(savedInstanceState: Bundle?, containedFragment: BaseFragment?) {
        if (savedInstanceState != null || containedFragment == null) return

        showFragment(containedFragment)
    }

}
