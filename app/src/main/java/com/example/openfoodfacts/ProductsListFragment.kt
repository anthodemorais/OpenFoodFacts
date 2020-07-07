package com.example.openfoodfacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_products_list.*
import kotlinx.android.synthetic.main.fragment_products_list.view.*

class ProductsListFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.fragment_products_list, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

        val product = Product("Petits pois et carottes", "Cassegrain", "3083680085304", "A", 3, false, true, "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg", "400 g (280 g net égoutté)", listOf("France", "Japon", "Suisse"), ingredients, listOf<String>(), listOf<String>(), infos)
        val product2 = Product("Petits pois et carottes 2", "Cassegrain", "3083680085304", "B", 2, false, true, "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg", "400 g (280 g net égoutté)", listOf("France", "Japon", "Suisse"), ingredients, listOf<String>(), listOf<String>(), infos)
        val product3 = Product("Petits pois et carottes 3", "Cassegrain", "3083680085304", "B", 2, false, true, "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg", "400 g (280 g net égoutté)", listOf("France", "Japon", "Suisse"), ingredients, listOf<String>(), listOf<String>(), infos)

        val products = listOf<Product>(product, product2, product3)

        // On initialise la RecyclerView on lui indiquant que l'on souhaite afficher la liste de produits
        products_list.layoutManager = LinearLayoutManager(requireContext())
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