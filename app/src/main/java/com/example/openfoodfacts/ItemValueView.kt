package com.example.openfoodfacts

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.view_item_value.view.*

class ItemValueView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val title: TextView
    private val value: TextView
    private val divider: View

    init {
        inflate(context, R.layout.view_item_value, this)

        title = item_value_title
        value = item_value_value
        divider = item_value_divider

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ItemValueView,
            0, 0
        ).apply {

            try {
                title.text = getString(R.styleable.ItemValueView_title)
                value.text = getString(R.styleable.ItemValueView_value)
                value.setTextColor(getColorStateList(R.styleable.ItemValueView_valueColor) ?: ColorStateList.valueOf(
                    ContextCompat.getColor(context, R.color.gray_3)
                ))
                divider.visibility = if (getInt(
                        R.styleable.ItemValueView_dividerVisibility,
                        0
                    ) == 0
                ) View.VISIBLE else View.GONE
            } finally {
                recycle()
            }
        }

    }

    @ColorInt
    var valueColor: Int = 0
        get() = value.currentTextColor
        set(color) {
            field = color
            value.setTextColor(color)
        }
}