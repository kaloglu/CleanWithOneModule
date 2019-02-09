package com.kaloglu.sample.presentation.interfaces.main

import com.kaloglu.sample.presentation.interfaces.activity.mvp.ActivityPresenter
import com.kaloglu.sample.presentation.interfaces.activity.mvp.ActivityView

interface MainContract {

    interface View : ActivityView

    interface Presenter : ActivityPresenter<View>
}
