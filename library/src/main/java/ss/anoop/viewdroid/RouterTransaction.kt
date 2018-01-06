package ss.anoop.viewdroid

import ss.anoop.viewdroid.transition.Transition

/**
 * Created by anoopss on 14/12/17.
 */
class RouterTransaction {

    private lateinit var screen : Screen

    private var enterTransition: Transition? = null

    private var exitTransition: Transition? = null

    fun with(screen: Screen) : RouterTransaction {
        this.screen = screen
        return this
    }

    fun enterTransition(transition: Transition): RouterTransaction {
        enterTransition = transition
        return this
    }

    fun exitTransition(transition: Transition): RouterTransaction {
        exitTransition = transition
        return this
    }

    fun getScreen() = screen

    fun getEnterTransition() = enterTransition

    fun getExitTransition() = exitTransition
}