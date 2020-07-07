package com.example.openfoodfacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details_header.*
import kotlinx.android.synthetic.main.fragment_details_summary.*
import kotlinx.android.synthetic.main.fragment_details_summary_content.*

class ProductDetailsSummaryFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details_summary, container, false)
    }

    fun bindProduct(product: Product) {
        headerTitle.text = product.name
        headerCompany.text = product.brand
        Picasso.get().load(product.imgUrl).into(headerImg)

        if (product.nutriscore == "A") {
            nutriscoreImg.setImageResource(R.mipmap.nutriscore_a)
        }
        else if (product.nutriscore == "B") {
            nutriscoreImg.setImageResource(R.mipmap.nutriscore_b)
        }
        else if (product.nutriscore == "C") {
            nutriscoreImg.setImageResource(R.mipmap.nutriscore_c)
        }
        else if (product.nutriscore == "D") {
            nutriscoreImg.setImageResource(R.mipmap.nutriscore_d)
        }
        else if (product.nutriscore == "E") {
            nutriscoreImg.setImageResource(R.mipmap.nutriscore_e)
        }

    }

}