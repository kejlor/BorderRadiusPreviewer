package com.example.borderradiuspreviewer

import android.graphics.*
import androidx.annotation.ColorInt

class DrawRectangle(@ColorInt private val color: Int) : Painter {
    private var topLeftRadius = 0f
    private var topRightRadius = 0f
    private var bottomLeftRadius = 0f
    private var bottomRightRadius = 0f
    private val paint = Paint()
    private val path = Path()
    private val corners = floatArrayOf(
        topLeftRadius, topLeftRadius,   // Top left radius in px
        topRightRadius, topRightRadius,   // Top right radius in px
        bottomRightRadius, bottomRightRadius,     // Bottom right radius in px
        bottomLeftRadius, bottomLeftRadius      // Bottom left radius in px
    )
    override fun paint(canvas: Canvas) {
        drawBackground(canvas)
    }
    private fun drawBackground(canvas: Canvas) {
        paint.color = color
        val width = canvas.width.toFloat()
        val height = canvas.height.toFloat()
        val rectF = RectF(width / 4 ,height / 4, width / 4 * 3, height / 4 * 3)
        path.addRoundRect(rectF, corners, Path.Direction.CW)
        canvas.drawPath(path, paint)
    }
    fun changeTopLeftRadius(radius: Float, canvas: Canvas) {
        topLeftRadius = radius
        drawBackground(canvas)
    }
    fun changeTopRightRadius(radius: Float, canvas: Canvas) {
        topRightRadius = radius
        drawBackground(canvas)
    }
    fun changeBottomRightRadius(radius: Float, canvas: Canvas) {
        bottomRightRadius = radius
        drawBackground(canvas)
    }
    fun changeBottomLeftRadius(radius: Float, canvas: Canvas) {
        bottomLeftRadius = radius
        drawBackground(canvas)
    }
}
