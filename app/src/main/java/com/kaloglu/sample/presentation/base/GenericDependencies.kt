package com.kaloglu.sample.presentation.base

import com.kaloglu.sample.injection.scopes.PerActivity
import com.kaloglu.sample.navigation.ActivityNavigator
import com.kaloglu.sample.navigation.FragmentNavigator
import javax.inject.Inject

@PerActivity
class GenericDependencies @Inject constructor(
        val activityNavigator: ActivityNavigator,
        val fragmentNavigator: FragmentNavigator
)
