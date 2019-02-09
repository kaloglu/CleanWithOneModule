package com.kaloglu.sample.mobileui.base.mvp

import com.kaloglu.sample.presentation.interfaces.fragment.mvp.FragmentPresenter
import com.kaloglu.sample.presentation.interfaces.fragment.mvp.FragmentView

abstract class FragmentAbstractPresenter<V : FragmentView> : BaseAbstractPresenter<V>(), FragmentPresenter<V>
