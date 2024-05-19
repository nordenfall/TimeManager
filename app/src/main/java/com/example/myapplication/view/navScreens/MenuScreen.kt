package com.example.myapplication.view.navScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.navigation.eventsNavigation.NavRoute
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun MenuScreen(navController: NavHostController){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.gray_back))
    ){
        Column(
            modifier = Modifier
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    "Меню",
                    style = TextStyle(
                        fontSize = 38.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        shadow = Shadow(
                            color = colorResource(id = R.color.gray_shadow),
                            offset = Offset(5.0f, 10.0f),
                            blurRadius = 3f
                        )
                    ),
                    modifier = Modifier.padding(start = 3.dp)
                )
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun MenuPreview(){
    MyApplicationTheme {
        MenuScreen(navController = rememberNavController())
    }
}