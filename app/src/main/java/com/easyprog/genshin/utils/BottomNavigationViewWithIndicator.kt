package com.easyprog.genshin.utils

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.MenuItem
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.doOnPreDraw
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator
import com.easyprog.genshin.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
import kotlin.math.abs

private const val DEFAULT_SCALE = 1f
private const val MAX_SCALE = 15f
private const val BASE_DURATION = 300L
private const val VARIABLE_DURATION = 300L

class BottomNavigationViewWithIndicator: BottomNavigationView,
    OnItemSelectedListener {

    private var externalSelectedListener: OnItemSelectedListener? = null
    private var animator: ValueAnimator? = null

    private val indicator = RectF()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.red)
    }

    private val bottomOffset = resources.getDimension(R.dimen.bottom_margin)
    private val defaultSize = resources.getDimension(R.dimen.default_size)

    constructor(context: Context): super(context)
    constructor(context: Context, attrs: AttributeSet?): super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defaultAttr: Int): super(context, attrs, defaultAttr)

    init {
        super.setOnItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (externalSelectedListener?.onNavigationItemSelected(item) != false) {
            onItemSelected(item.itemId)
            return true
        }
        return false
    }

    override fun setOnItemSelectedListener(listener: OnItemSelectedListener?) {
        externalSelectedListener = listener
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        doOnPreDraw {
            onItemSelected(selectedItemId, false)
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        cancelAnimator(setEndValues = true)
    }

    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)
        if (isLaidOut) {
            val cornerRadius = indicator.height() / 2f
            canvas?.drawRoundRect(indicator, cornerRadius, cornerRadius, paint)
        }
    }

    private fun onItemSelected(itemId: Int, animate: Boolean = true) {
        if (!isLaidOut) return

        cancelAnimator(setEndValues = false)

        val itemView = findViewById<View>(itemId) ?: return
        val fromCenterX = indicator.centerX()
        val fromScale = indicator.width() / defaultSize

        animator = ValueAnimator.ofFloat(fromScale, MAX_SCALE, DEFAULT_SCALE).apply {
            addUpdateListener {
                val progress = it.animatedFraction
                val distanceTravelled = linearInterpolation(progress, fromCenterX, itemView.centerX)

                val scale = it.animatedValue as Float
                val indicatorWidth = defaultSize * scale

                val left = distanceTravelled - indicatorWidth / 2f
                val top = height - bottomOffset - defaultSize
                val right = distanceTravelled + indicatorWidth / 2f
                val bottom = height - bottomOffset

                indicator.set(left, top, right, bottom)
                invalidate()
            }

            interpolator = LinearOutSlowInInterpolator()

            val distanceToMove = abs(fromCenterX - itemView.centerX)
            duration = if (animate) calculateDuration(distanceToMove) else 0L

            start()
        }
    }

    private fun linearInterpolation(t: Float, a: Float, b: Float) = (1 - t) * a + t * b

    private fun calculateDuration(distance: Float) =
        (BASE_DURATION + VARIABLE_DURATION * (distance / width).coerceIn(0f, 1f)).toLong()

    private val View.centerX get() = left + width / 2f

    private fun cancelAnimator(setEndValues: Boolean) = animator?.let {
        if (setEndValues) {
            it.end()
        } else {
            it.cancel()
        }
        it.removeAllUpdateListeners()
        animator = null
    }
}