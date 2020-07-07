package com.example.openfoodfacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details_header.*
import kotlinx.android.synthetic.main.fragment_details_nutritional_values_content.*
import kotlinx.android.synthetic.main.fragment_details_summary.*

class ProductDetailsNutritionalValuesFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details_nutritional_values, container, false)
    }

    fun bindProduct(product: Product) {
        headerTitle.text = product.name
        headerCompany.text = product.brand
        Picasso.get().load(product.imgUrl).into(headerImg)

        val energy: TableCellView = c2r1
        val fats: TableCellView = c2r2
        val satured: TableCellView = c2r3
        val carbs: TableCellView = c2r4
        val sugar: TableCellView = c2r5
        val fibers: TableCellView = c2r6
        val protein: TableCellView = c2r7
        val salt: TableCellView = c2r8
        val sodium: TableCellView = c2r9

        energy.text = product.infos.energy.quantityPer100g.toString() + product.infos.energy.unit
        fats.text = product.infos.fats.quantityPer100g.toString() + product.infos.fats.unit
        satured.text = product.infos.saturedFats.quantityPer100g.toString() + product.infos.saturedFats.unit
        carbs.text = product.infos.carbs.quantityPer100g.toString() + product.infos.carbs.unit
        sugar.text = product.infos.sugar.quantityPer100g.toString() + product.infos.sugar.unit
        fibers.text = product.infos.fibers.quantityPer100g.toString() + product.infos.fibers.unit
        protein.text = product.infos.protein.quantityPer100g.toString() + product.infos.protein.unit
        salt.text = product.infos.salt.quantityPer100g.toString() + product.infos.salt.unit
        sodium.text = product.infos.sodium.quantityPer100g.toString() + product.infos.sodium.unit
    }
}