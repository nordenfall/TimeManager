package com.example.myapplication.view.NavScreens


import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun MainScreen(navHostController: NavHostController){

}




@Preview(showBackground = true)
@Composable
fun MainPreview(){
    MyApplicationTheme {
        MainScreen(navHostController = rememberNavController())
    }
}