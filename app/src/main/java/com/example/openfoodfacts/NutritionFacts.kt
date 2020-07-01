package com.example.openfoodfacts

class NutritionFacts {
    var energy: NutritionFactsItem
    var fats: NutritionFactsItem
    var saturedFats: NutritionFactsItem
    var carbs: NutritionFactsItem
    var sugar: NutritionFactsItem
    var fibers: NutritionFactsItem
    var protein: NutritionFactsItem
    var salt: NutritionFactsItem
    var sodium: NutritionFactsItem

    constructor(energy: NutritionFactsItem, fats: NutritionFactsItem, saturedFats: NutritionFactsItem, carbs: NutritionFactsItem, sugar: NutritionFactsItem, fibers: NutritionFactsItem, protein: NutritionFactsItem, salt: NutritionFactsItem, sodium: NutritionFactsItem) {
        this.energy = energy
        this.fats = fats
        this.saturedFats = saturedFats
        this.carbs = carbs
        this.sugar = sugar
        this.fibers = fibers
        this.protein = protein
        this.salt = salt
        this.sodium = sodium
    }
}