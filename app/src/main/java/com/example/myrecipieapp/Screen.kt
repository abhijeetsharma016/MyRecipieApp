package com.example.myrecipieapp

sealed class Screen(val route:String) {
    object RecepieScreen: Screen("recipescreen")
    object DetailScreen: Screen("detailscreen")
}