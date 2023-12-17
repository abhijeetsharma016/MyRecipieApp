package com.example.myrecipieapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController){
    val recipeViewModel: MainViewModel = viewModel()
    val viewState by recipeViewModel.categoryState
    
    NavHost(navController = navController, startDestination = Screen.RecepieScreen.route){
        composable(route = Screen.RecepieScreen.route){
            RecipeScreen(viewstate = viewState, navigateToDetail = {
                navController.currentBackStackEntry?.savedStateHandle?.set("cat",it)
                navController.navigate(Screen.DetailScreen.route)
            })
        }
        composable(route = Screen.DetailScreen.route){
            val category =
                navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat")
                    ?: Category("", "", "", "")
            CategoryDetailScreen(category = category)
        }
    }
}