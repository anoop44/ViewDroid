package ss.anoop.viewdroid.transition

import android.animation.Animator
import android.view.View

/**
 * Created by anoopss on 04/01/18.
 */
interface Transition {

    fun animation(from: View?, to: View?, isEnter: Boolean): Animator
}