package com.eagle.gkpedia.monitor.ui

import android.view.ViewGroup
import com.eagle.gkpedia.monitor.ui.base.Screen
import okhttp3.Route
import java.util.*

/**
 * Created by anoopss on 24/11/17.
 */
class Router {

    private val backstack: Stack<Screen> = Stack()

    companion object {

        private var screenContainer: ViewGroup? = null

        fun init(container: ViewGroup): Router {
            screenContainer = container
            return Router()
        }
    }

    fun presentScreen(screen: Screen) {

        backstack.add(screen)

        screen.createView(screenContainer?.context)

        screenContainer?.addView(screen.getView())

    }

    fun handleBack(): Boolean {

        var handled = false
        if (backstack.isNotEmpty()) {
            handled = backstack.peek().handleBack()

            if (!handled && backstack.size > 1) {
                screenContainer?.removeView(backstack.peek().getView())
                backstack.peek().destroy()
                backstack.pop()

                handled = true
            }
        }

        return handled
    }
}