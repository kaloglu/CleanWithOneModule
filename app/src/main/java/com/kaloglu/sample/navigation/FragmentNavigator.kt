package com.kaloglu.sample.navigation

import androidx.fragment.app.FragmentManager
import com.kaloglu.sample.R
import com.kaloglu.sample.injection.scopes.PerActivity
import com.kaloglu.sample.mobileui.base.BaseFragment
import javax.inject.Inject

//TODO: could be abstract
@PerActivity
class FragmentNavigator @Inject constructor(private val fragmentManager: FragmentManager) {
    //TODO: could be abstract
    val containerId: Int = R.id.activity_fragment_container

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
