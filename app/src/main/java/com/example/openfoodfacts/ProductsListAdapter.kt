package com.example.openfoodfacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_product_item.view.*

class ProductsListAdapter(private val products: List<Product>, private val clickListener: OnProductItemClicked) : RecyclerView.Adapter<ProductsListAdapter.ViewHolder>() {

    // On indique que notre cellule utilise le layout créé
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_product_item, parent, false)
        )

    // Il y a autant de cellules que de products
    override fun getItemCount(): Int = products.size

    // Pour chaque cellule, on lui assigne le bon objet Product
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindProduct(products[position])
    }

    inner class ViewHolder(v: View): RecyclerView.ViewHolder(v) {

        // TODO Lister toutes les vues
        private val title: TextView = v.title
        private val company: TextView = v.company
        private val score: TextView = v.score
        private  val image: ImageView = v.image


        fun bindProduct(product: Product) {
            itemView.setOnClickListener {
                clickListener.onProductClicked(product)
            }

            // TODO Assignez à vos vues les valeurs de l'objet Product
            title.text = product.name
            company.text = product.brand
            score.text = "Nutriscore : " + product.nutriscore
            Picasso.get().load(product.imgUrl).into(image)
        }

    }

    // Une interface pour notifier que l'utilisateur a cliqué sur un produit de la liste
    interface OnProductItemClicked {
        fun onProductClicked(product: Product)
    }

}