package ss.anoop.viewdroid.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import ss.anoop.viewdroid.sample.R

/**
 * Created by anoopss on 15/12/17.
 */
class CircleView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private var radius : Int? = 40

    private var color : Int? = Color.BLACK

    private var circlePaint  : Paint = Paint()

    init {
        circlePaint.flags = Paint.ANTI_ALIAS_FLAG

         var typedArray = context?.obtainStyledAttributes(attrs!!, R.styleable.CircleView,0, 0)

        radius = typedArray?.getDimensionPixelSize(R.styleable.CircleView_circleRadius, 40)

        color = typedArray?.getColor(R.styleable.CircleView_circleColor, Color.BLACK)

        circlePaint.color = color!!
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var dimen = radius?.times(2)
        setMeasuredDimension(dimen!!, dimen!!)
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawCircle((top + radius!!).toFloat(), (left + radius!!).toFloat(), radius!!.toFloat(), circlePaint)
    }
}