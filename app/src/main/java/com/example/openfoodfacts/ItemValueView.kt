package com.example.openfoodfacts

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
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
}