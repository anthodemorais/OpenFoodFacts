package com.example.openfoodfacts

class Product(name: String,
              brand: String,
              barcode: String,
              nutriscore: String,
              novascore: Int,
              is_vegetarian: Boolean,
              is_vegan: Boolean,
              imgUrl: String,
              quantity: String,
              countries: List<String>,
              ingredients: List<String>,
              allergens: List<String>,
              additives: List<String>
) {
}