package ss.anoop.viewdroid

import android.view.ViewGroup
import java.util.*

/**
 * Created by anoopss on 24/11/17.
 */
class Router {

    private val backstack: Stack<RouterTransaction> = Stack()

    companion object {

        private var screenContainer: ViewGroup? = null

        fun init(container: ViewGroup): Router {
            screenContainer = container
            return Router()
        }
    }

    private constructor()

    fun presentScreen(routerTransaction: RouterTransaction) {

        backstack.add(routerTransaction)

        routerTransaction.getScreen().setRouter(this)

        routerTransaction.getScreen().createView(screenContainer?.context)

        screenContainer?.addView(routerTransaction.getScreen().getView())

        routerTransaction.getEnterTransition()?.animation(null, routerTransaction.getScreen().getView(), true)?.start()

    }

    fun replaceScreen(routerTransaction: RouterTransaction) {
        if (!backstack.isEmpty()) {
            backstack.pop()!!.getScreen().destroy()
        }
        presentScreen(routerTransaction)
    }

    fun pop() {
        handleBack()
    }

    fun handleBack(): Boolean {

        var handled = false
        if (backstack.isNotEmpty()) {
            handled = backstack.peek().getScreen().handleBack()

            if (!handled && backstack.size > 1) {

                popScreen()

                handled = true
            }
        }

        return handled
    }

    private fun popScreen() {
        screenContainer?.removeView(backstack.peek().getScreen().getView())
        backstack.peek().getScreen().destroy()
        backstack.pop()

        if (backstack.size > 0) {
            backstack.peek().getScreen().onScreenResume()
        }
    }
}