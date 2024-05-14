package com.example.myapplication.navigation

sealed class NavRoute(val route:String) {
    object StartScreen: NavRoute("start_screen")
    object MainScreen: NavRoute("main_screen")
    object AddScreen: NavRoute("add_screen")
    object EventScreen: NavRoute("event_screen")
}