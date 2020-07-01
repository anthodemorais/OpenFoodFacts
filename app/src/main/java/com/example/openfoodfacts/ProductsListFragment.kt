package com.example.openfoodfacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ProductsListFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val ingredients = listOf("Petits pois 66%", "eau", "garniture 2,8% (salade, oignon grelot)", "sucre", "sel", "arôme naturel")
        val product = Product("Petits pois et carottes", "Cassegrain", "3083680085304", "A", 3, false, true, "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg", "400 g (280 g net égoutté)", listOf("France", "Japon", "Suisse"), ingredients, listOf<String>(), listOf<String>())
        val product2 = Product("Petits pois et carottes 2", "Cassegrain", "3083680085304", "B", 2, false, true, "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg", "400 g (280 g net égoutté)", listOf("France", "Japon", "Suisse"), ingredients, listOf<String>(), listOf<String>())
        val product3 = Product("Petits pois et carottes 3", "Cassegrain", "3083680085304", "B", 2, false, true, "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg", "400 g (280 g net égoutté)", listOf("France", "Japon", "Suisse"), ingredients, listOf<String>(), listOf<String>())

        return inflater.inflate(R.layout.fragment_products_list, container, false)
    }
}