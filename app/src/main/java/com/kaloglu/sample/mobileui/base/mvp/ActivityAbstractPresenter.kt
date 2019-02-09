package com.kaloglu.sample.mobileui.base.mvp

import com.kaloglu.sample.presentation.interfaces.activity.mvp.ActivityPresenter
import com.kaloglu.sample.presentation.interfaces.activity.mvp.ActivityView

abstract class ActivityAbstractPresenter<V : ActivityView> : BaseAbstractPresenter<V>(), ActivityPresenter<V>
