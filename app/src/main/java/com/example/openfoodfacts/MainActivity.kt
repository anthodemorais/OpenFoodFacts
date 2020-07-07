package com.example.openfoodfacts

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.fragment_details_summary)
        // setContentView(R.layout.fragment_details_nutrition)
        setContentView(R.layout.fragment_products_list)

        supportActionBar?.let {
            it.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this@MainActivity, android.R.color.transparent)))
            it.title = ""
        }
    }
}