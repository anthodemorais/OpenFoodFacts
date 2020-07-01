package com.example.openfoodfacts

class NutritionFactsItem {

    var unit: String
    var quantityPerPortion: Float
    var quantityPer100g: Float

    constructor(unit: String, quantityPerPortion: Float, quantityPer100g: Float) {
        this.unit = unit
        this.quantityPerPortion = quantityPerPortion
        this.quantityPer100g = quantityPer100g
    }
}