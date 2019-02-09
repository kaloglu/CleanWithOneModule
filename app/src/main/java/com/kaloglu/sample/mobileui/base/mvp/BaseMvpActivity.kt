package com.kaloglu.sample.mobileui.base.mvp

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.kaloglu.sample.mobileui.base.BaseActivity
import com.kaloglu.sample.mobileui.base.BaseFragment
import com.kaloglu.sample.presentation.interfaces.activity.mvp.ActivityPresenter
import com.kaloglu.sample.presentation.interfaces.activity.mvp.ActivityView
import javax.inject.Inject

//class GenericBar<S : GenericInterface<out FooInterface>> {
//    var s: S? = null
//}
abstract class BaseMvpActivity<P : ActivityPresenter<ActivityView>> : BaseActivity(), ActivityView {

    //TODO: override for initial if you need
    override val containedFragment: BaseFragment? = null

    override val snackbarLayoutId: Int?
        get() = null

    protected var badgeVisible: Int = -1

    @Inject
    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
        onPresenterAttached()
        showInitialFragment(savedInstanceState)
    }


    private fun showInitialFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) return

        presenter.showFragment(containedFragment)
        presenter.showInitialFragment(savedInstanceState, containedFragment)
    }

    override fun onDestroy() {
        onPresenterDetached()
        presenter.detachView()
        super.onDestroy()
    }

    override fun showSnackbar(messageId: Int) =
            showSnackbar(resources.getString(messageId))


    override fun showSnackbar(message: String) = snackbarLayoutId?.let {
        Snackbar.make(
                findViewById(it),
                message,
                Snackbar.LENGTH_LONG
        ).show()
    } ?: Toast.makeText(this, "SnackbarLayout tanımlanmamış: $message", Toast.LENGTH_LONG).show()

    // Override this on child activities if needed.
    protected open fun onPresenterAttached() = Unit

    // Override this on child activities if needed.
    protected open fun onPresenterDetached() = Unit
}
