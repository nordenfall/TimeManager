package com.example.myapplication.view

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun StartScreen(navHostController: NavHostController){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {

        }

    }
}




@Preview(showBackground = true)
@Composable
fun StartPreview(){
    MyApplicationTheme {
        StartScreen(navHostController = rememberNavController())
    }
}
