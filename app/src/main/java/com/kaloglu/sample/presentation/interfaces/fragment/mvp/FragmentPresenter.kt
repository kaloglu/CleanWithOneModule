package com.kaloglu.sample.presentation.interfaces.fragment.mvp

import com.kaloglu.sample.presentation.interfaces.base.mvp.BasePresenter

interface FragmentPresenter<out V : FragmentView> : BasePresenter<V>
