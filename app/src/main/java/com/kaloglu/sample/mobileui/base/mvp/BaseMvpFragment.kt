package com.kaloglu.sample.mobileui.base.mvp

import android.os.Bundle
import android.view.View
import com.kaloglu.sample.mobileui.base.BaseFragment
import com.kaloglu.sample.presentation.interfaces.base.mvp.BasePresenter
import com.kaloglu.sample.presentation.interfaces.base.mvp.BaseView
import javax.inject.Inject

abstract class BaseMvpFragment<P : BasePresenter<BaseView>> : BaseFragment(), BaseView {

    @Inject
    lateinit var presenter: P

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        onPresenterAttached()
    }

    override fun onDestroyView() {
        onPresenterDetached()
        presenter.detachView()
        super.onDestroyView()
    }

    // Override this on child fragments if needed.
    protected open fun onPresenterAttached() = Unit

    // Override this on child fragments if needed.
    protected open fun onPresenterDetached() = Unit
}
