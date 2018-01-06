package ss.anoop.viewdroid.screens

import android.os.Bundle
import android.view.View
import ss.anoop.viewdroid.RouterTransaction
import ss.anoop.viewdroid.sample.R
import ss.anoop.viewdroid.Screen
import ss.anoop.viewdroid.sample.screens.NavigationDemoScreen

/**
 * Created by anoopss on 15/12/17.
 */
class OptionsListScreen : Screen() {

    override fun getLayout(): Int = R.layout.options_list_screen_layout

    override fun onViewCreated(v: View) {
        super.onViewCreated(v)

        val bundle = Bundle()
        bundle.putInt(NavigationDemoScreen.Keys.NUMBER, 1)

        v.findViewById<View>(R.id.navigation_demo).setOnClickListener { getRouter().presentScreen(RouterTransaction().with(NavigationDemoScreen(bundle))) }
    }
}