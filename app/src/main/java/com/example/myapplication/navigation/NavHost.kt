package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.view.AddScreen
import com.example.myapplication.view.EventScreen
import com.example.myapplication.view.MainScreen
import com.example.myapplication.view.StartScreen


@Composable
fun NavHost() {
    val navController = rememberNavController()
    androidx.navigation.compose.NavHost(
        navController = navController,
        startDestination = NavRoute.StartScreen.route) {
        composable(NavRoute.StartScreen.route){
            StartScreen(navController)
        }
        composable(NavRoute.MainScreen.route){
            MainScreen(navController)
        }
        composable(NavRoute.AddScreen.route){
            AddScreen(navController)
        }
        composable(NavRoute.EventScreen.route){
            EventScreen(navController)
        }
    }
}