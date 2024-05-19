package com.example.myapplication.view.navScreens
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun MainScreen(navController: NavHostController){
    var showDialog by remember { mutableStateOf(false)}
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
                IconButton(onClick = {
                /* Обработка клика по меню */
                }
                ) {
                    Icon(
                        Icons.Filled.Menu,
                        contentDescription = "Menu",
                        modifier = Modifier.size(35.dp))
                }

                Text(
                    "Расписание",
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

            WorkArea()
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun WorkArea() {
    val daysOfWeek = listOf("Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье")
    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)) {
        items(daysOfWeek) { day ->
            DayCard(day)
        }
    }
}

@Composable
fun DayCard(day: String) {
    Card(
        elevation = CardDefaults.cardElevation(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Обработка клика на день */ }
    ) {
        Text(
            text = day,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview(){
    MyApplicationTheme {
        MainScreen(navController = rememberNavController())
    }
}