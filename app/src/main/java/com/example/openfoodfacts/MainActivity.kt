package com.example.openfoodfacts

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_products_list.*
import kotlinx.android.synthetic.main.fragment_products_list.view.*

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

        val ingredients = listOf("Petits pois 66%", "eau", "garniture 2,8% (salade, oignon grelot)", "sucre", "sel", "arôme naturel")

        val energy = NutritionFactsItem("kj", 293F, 293F)
        val fats = NutritionFactsItem("g", 0.8F, 0.8F)
        val saturedFats = NutritionFactsItem("g", 0.1F, 0.1F)
        val carbs = NutritionFactsItem("g", 8.4F, 8.4F)
        val sugar = NutritionFactsItem("g", 5.2F, 5.2F)
        val fibers = NutritionFactsItem("g", 5.2F, 5.2F)
        val protein = NutritionFactsItem("g", 4.8F, 4.8F)
        val salt = NutritionFactsItem("g", 0.75F, 0.75F)
        val sodium = NutritionFactsItem("mg", 0.295F, 0.295F)
        val infos = NutritionFacts(energy, fats, saturedFats, carbs, sugar, fibers, protein, salt, sodium)

        var colorFat = Color.RED
        var colorSaturedFats = Color.RED
        var colorSugar = Color.RED
        var colorSalt = Color.RED

        if (fats.quantityPer100g <= 3F) {
            colorFat = Color.GREEN
        }
        else if (fats.quantityPer100g <= 20F) {
            colorFat = Color.YELLOW
        }

        if (saturedFats.quantityPer100g <= 1.5F) {
            colorSaturedFats = Color.GREEN
        }
        else if (saturedFats.quantityPer100g <= 5F) {
            colorSaturedFats = Color.YELLOW
        }

        if (sugar.quantityPer100g <= 5F) {
            colorSugar = Color.GREEN
        }
        else if (sugar.quantityPer100g <= 12.5F) {
            colorSugar = Color.YELLOW
        }

        if (salt.quantityPer100g <= 0.3F) {
            colorSalt = Color.GREEN
        }
        else if (salt.quantityPer100g <= 1.5F) {
            colorSalt = Color.YELLOW
        }

        val product = Product("Petits pois et carottes", "Cassegrain", "3083680085304", "A", 3, false, true, "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg", "400 g (280 g net égoutté)", listOf("France", "Japon", "Suisse"), ingredients, listOf<String>(), listOf<String>(), infos)
        val product2 = Product("Petits pois et carottes 2", "Cassegrain", "3083680085304", "B", 2, false, true, "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg", "400 g (280 g net égoutté)", listOf("France", "Japon", "Suisse"), ingredients, listOf<String>(), listOf<String>(), infos)
        val product3 = Product("Petits pois et carottes 3", "Cassegrain", "3083680085304", "B", 2, false, true, "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg", "400 g (280 g net égoutté)", listOf("France", "Japon", "Suisse"), ingredients, listOf<String>(), listOf<String>(), infos)

        val products = listOf<Product>(product, product2, product3)

        // On initialise la RecyclerView on lui indiquant que l'on souhaite afficher la liste de produits
        products_list.layoutManager = LinearLayoutManager(this)
        products_list.adapter = ProductsListAdapter(products, object : ProductsListAdapter.OnProductItemClicked {
            override fun onProductClicked(product: Product) {
                // TODO L'utilisateur a cliqué sur le produit reçu en paramètre
                // Ouvrir l'écran de détails
            }
        })

        if (products.size > 0) {
            products_list.emptyView.visibility = View.GONE
        }
        else {
            products_list.products_list.visibility = View.GONE
        }
    }
}