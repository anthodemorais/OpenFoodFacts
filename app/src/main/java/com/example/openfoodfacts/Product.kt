package com.example.openfoodfacts

class Product {

    var name: String
    var brand: String
    var barcode: String
    var nutriscore: String
    var novascore: Int
    var is_vegetarian: Boolean
    var is_vegan: Boolean
    var imgUrl: String
    var quantity: String
    var countries: List<String>
    var ingredients: List<String>
    var allergens: List<String>
    var additives: List<String>
    var infos: NutritionFacts

    constructor(name: String,
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
                additives: List<String>,
                infos: NutritionFacts)
    {
        this.name = name
        this.brand = brand
        this.barcode = barcode
        this.nutriscore = nutriscore
        this.novascore = novascore
        this.is_vegetarian = is_vegetarian
        this.is_vegan = is_vegan
        this.imgUrl = imgUrl
        this.quantity = quantity
        this.countries = countries
        this.ingredients = ingredients
        this.allergens = allergens
        this.additives = additives
        this.infos = infos
    }
}