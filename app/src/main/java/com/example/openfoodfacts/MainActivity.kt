package com.example.openfoodfacts

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_details_summary)

        supportActionBar?.let {
            it.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this@MainActivity, android.R.color.transparent)))
            it.title = ""
        }

        val ingredients = listOf("Petits pois 66%", "eau", "garniture 2,8% (salade, oignon grelot)", "sucre", "sel", "arôme naturel")
        val product = Product("Petits pois et carottes", "Cassegrain", "3083680085304", "A", 3, false, true, "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg", "400 g (280 g net égoutté)", listOf("France", "Japon", "Suisse"), ingredients, listOf<String>(), listOf<String>())
    }
}