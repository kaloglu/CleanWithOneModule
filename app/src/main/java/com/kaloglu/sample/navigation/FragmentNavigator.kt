package com.kaloglu.sample.navigation

import androidx.fragment.app.FragmentManager
import com.kaloglu.sample.injection.scopes.PerActivity
import com.kaloglu.sample.injection.scopes.PerFragment
import com.kaloglu.sample.mobileui.base.BaseFragment

@PerActivity
@PerFragment
abstract class FragmentNavigator constructor(
        private val fragmentManager: FragmentManager,
        private val containerId: Int
) {

    fun showFragment(fragment: BaseFragment) =
            fragmentManager.beginTransaction()
                    .replace(containerId, fragment)
                    .addToBackStack(fragment.fragmentTag)
                    .commit()

    fun popBackStack() = fragmentManager.popBackStack()

    fun clearPopStack() {
        var count = fragmentManager.backStackEntryCount
        while (count > 1) {
            fragmentManager.popBackStack()
            count--
        }
    }

}
