package com.example.openfoodfacts

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details_header.*
import kotlinx.android.synthetic.main.fragment_details_nutrition_content.*
import kotlinx.android.synthetic.main.fragment_details_summary.*
import kotlinx.android.synthetic.main.view_item_value.view.*

class ProductDetailsNutritionFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details_nutrition, container, false)
    }

    fun bindProduct(product: Product) {
        headerTitle.text = product.name
        headerCompany.text = product.brand
        Picasso.get().load(product.imgUrl).into(headerImg)

        var colorFat = Color.RED
        var colorSaturedFats = Color.RED
        var colorSugar = Color.RED
        var colorSalt = Color.RED

        if (product.infos.fats.quantityPer100g <= 3F) {
            colorFat = Color.GREEN
        }
        else if (product.infos.fats.quantityPer100g <= 20F) {
            colorFat = Color.YELLOW
        }

        if (product.infos.saturedFats.quantityPer100g <= 1.5F) {
            colorSaturedFats = Color.GREEN
        }
        else if (product.infos.saturedFats.quantityPer100g <= 5F) {
            colorSaturedFats = Color.YELLOW
        }

        if (product.infos.sugar.quantityPer100g <= 5F) {
            colorSugar = Color.GREEN
        }
        else if (product.infos.sugar.quantityPer100g <= 12.5F) {
            colorSugar = Color.YELLOW
        }

        if (product.infos.salt.quantityPer100g <= 0.3F) {
            colorSalt = Color.GREEN
        }
        else if (product.infos.salt.quantityPer100g <= 1.5F) {
            colorSalt = Color.YELLOW
        }

        fat.valueColor = colorFat
        fat.item_value_value.text = product.infos.fats.quantityPer100g.toString() + product.infos.fats.unit

        saturatedFat.valueColor = colorSaturedFats
        saturatedFat.item_value_value.text = product.infos.saturedFats.quantityPer100g.toString() + product.infos.saturedFats.unit

        sugar.valueColor = colorSugar
        sugar.item_value_value.text = product.infos.sugar.quantityPer100g.toString() + product.infos.sugar.unit

        salt.valueColor = colorSalt
        salt.item_value_value.text = product.infos.salt.quantityPer100g.toString() + product.infos.salt.unit
    }
}