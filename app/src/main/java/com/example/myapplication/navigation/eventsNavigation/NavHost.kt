package com.example.myapplication.navigation.eventsNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.view.eventScreens.AddScreen
import com.example.myapplication.view.eventScreens.EventScreen
import com.example.myapplication.view.eventScreens.StartScreen
import com.example.myapplication.view.navScreens.MainScreen
import com.example.myapplication.view.navScreens.ProfileScreen
import com.example.myapplication.view.navScreens.TagScreen

sealed class NavRoute(val route:String){
    data object AddScreen:NavRoute("add_screen")
    data object EventScreen:NavRoute("event_screen")
    data object StartScreen:NavRoute("start_screen")
    data object MainScreen:NavRoute("main_screen")
    data object ProfileScreen:NavRoute("profile_screen")
    data object TagScreen:NavRoute("tag_screen")
}

@Composable
fun AppNavHost(){
    val navController = rememberNavController()
    androidx.navigation.compose.NavHost(
        navController = navController,
        startDestination = NavRoute.StartScreen.route
    ) {
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
        composable(NavRoute.ProfileScreen.route){
           ProfileScreen(navController)
        }
        composable(NavRoute.TagScreen.route){
            TagScreen(navController)
        }
    }
}