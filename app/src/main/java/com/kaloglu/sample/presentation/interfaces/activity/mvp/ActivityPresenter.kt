package com.kaloglu.sample.presentation.interfaces.activity.mvp

import com.kaloglu.sample.presentation.interfaces.base.mvp.BasePresenter

interface ActivityPresenter<out V : ActivityView> : BasePresenter<V>
