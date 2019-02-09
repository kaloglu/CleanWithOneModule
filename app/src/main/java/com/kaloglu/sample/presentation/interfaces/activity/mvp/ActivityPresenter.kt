package com.kaloglu.sample.presentation.interfaces.activity.mvp

import android.os.Bundle
import com.kaloglu.sample.mobileui.base.BaseFragment
import com.kaloglu.sample.presentation.interfaces.base.mvp.BasePresenter

interface ActivityPresenter<out V : ActivityView> : BasePresenter<V> {

    fun showInitialFragment(savedInstanceState: Bundle?, containedFragment: BaseFragment?)
}
