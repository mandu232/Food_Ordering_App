package com.example.food

import android.content.Context
import android.graphics.LinearGradient
import android.graphics.Shader
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat

/** Applies the app's start/end colors to the text, including layout previews. */
class GradientTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = android.R.attr.textViewStyle
) : AppCompatTextView(context, attrs, defStyleAttr) {

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if (w <= paddingLeft + paddingRight) return

        paint.shader = LinearGradient(
            paddingLeft.toFloat(),
            0f,
            (w - paddingRight).toFloat(),
            0f,
            ContextCompat.getColor(context, R.color.startColor),
            ContextCompat.getColor(context, R.color.endColor),
            Shader.TileMode.CLAMP
        )
    }
}
