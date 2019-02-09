package com.kaloglu.sample.presentation.main

import com.kaloglu.sample.mobileui.base.mvp.ActivityAbstractPresenter
import com.kaloglu.sample.presentation.base.GenericDependencies
import com.kaloglu.sample.presentation.interfaces.main.MainContract
import javax.inject.Inject

class MainPresenter @Inject constructor(
        override val genericDependencies: GenericDependencies
) : ActivityAbstractPresenter<MainContract.View>(), MainContract.Presenter
