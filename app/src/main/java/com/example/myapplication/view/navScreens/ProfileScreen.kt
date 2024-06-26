package com.example.myapplication.view.navScreens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun ProfileScreen(navController: NavHostController){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding->

    }
}




@Preview(showBackground = true)
@Composable
fun ProfilePreview(){
    MyApplicationTheme {
        ProfileScreen(navController = rememberNavController())
    }
}