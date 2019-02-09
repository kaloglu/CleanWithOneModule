package com.kaloglu.sample.presentation.interfaces.base.navigator

import androidx.fragment.app.FragmentManager
import com.kaloglu.sample.R
import com.kaloglu.sample.navigation.FragmentNavigator
import javax.inject.Inject

class BaseFragmentNavigator @Inject constructor(fragmentManger: FragmentManager)
    : FragmentNavigator(fragmentManger, R.id.fragment_container)
