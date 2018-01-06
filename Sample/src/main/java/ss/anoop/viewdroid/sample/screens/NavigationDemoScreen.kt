package ss.anoop.viewdroid.sample.screens

import android.os.Bundle
import android.view.View
import android.widget.TextView
import ss.anoop.viewdroid.RouterTransaction
import ss.anoop.viewdroid.Screen
import ss.anoop.viewdroid.sample.R
import ss.anoop.viewdroid.transition.HorizontalTransition

/**
 * Created by anoopss on 15/12/17.
 */
class NavigationDemoScreen(bundle: Bundle) : Screen(bundle) {

    private val colorList = arrayListOf(R.color.navigation_screen_colors_1, R.color.navigation_screen_colors_2, R.color.navigation_screen_colors_3, R.color.navigation_screen_colors_4, R.color.navigation_screen_colors_5, R.color.navigation_screen_colors_6)

    override fun getLayout() = R.layout.navigation_demo_screen_layout


    override fun onViewCreated(v: View) {
        super.onViewCreated(v)

        val bundle = getArgs()

        val number = bundle?.getInt(Keys.NUMBER)

        v.findViewById<TextView>(R.id.navigation_screen_text).text = "Navigation Screen #" + number

        v.setBackgroundResource(colorList[number!!.rem(colorList.size)])

        v.findViewById<View>(R.id.next_screen).setOnClickListener {
            bundle?.putInt(Keys.NUMBER, number + 1)
            getRouter().presentScreen(RouterTransaction().with(NavigationDemoScreen(bundle)).enterTransition(HorizontalTransition()))
        }

    }

    object Keys {
        val NUMBER = "number"
    }
}