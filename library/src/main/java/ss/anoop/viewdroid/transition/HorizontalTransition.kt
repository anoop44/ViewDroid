package ss.anoop.viewdroid.transition

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View

/**
 * Created by anoopss on 04/01/18.
 */
class HorizontalTransition : Transition {

    override fun animation(from: View?, to: View?, isEnter: Boolean): Animator {

        val animatorSet = AnimatorSet()

        if (isEnter) {
            animatorSet.play(ObjectAnimator.ofFloat(to,View.TRANSLATION_X, (to?.width ?: 0).toFloat() , 0F))
        } else {
            animatorSet.play(ObjectAnimator.ofFloat(to,View.TRANSLATION_X, 0F, (to?.measuredWidth ?: 0) * -1F))
        }

        return animatorSet
    }
}