package com.example.myapplication.view.navScreens
import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.model.Day
import com.example.myapplication.model.Event
import com.example.myapplication.navigation.eventsNavigation.NavRoute
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.viewModel.MainViewModel
import com.example.myapplication.viewModel.MainViewModelFactory

@Composable
fun MainScreen(navController: NavHostController){
    val context = LocalContext.current
    val mViewModel: MainViewModel = viewModel(
        factory = MainViewModelFactory(context.applicationContext as Application))
    val showDialog = remember { mutableStateOf(false) }
    val days = mViewModel.days.observeAsState(listOf()).value

    showDialog.value = false
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
                IconButton(onClick = {navController.navigate(NavRoute.MenuScreen.route)}
                ) {
                    Icon(
                        Icons.Filled.Menu,
                        contentDescription = "Menu",
                        modifier = Modifier.size(35.dp)
                    )
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
            WeekMonthParameter()
            LazyColumn(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(days){day ->
                    val events = mViewModel.getEventsForDay(day.dayId).value?: emptyList()
                    DayCard(day = day, events = events)
                }
            }
        }
    }
}

@Composable
fun DayCard(day:Day, events:List<Event>) {
    val showDialog = remember { mutableStateOf(false) }
    Card(
        elevation = CardDefaults.cardElevation(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .clickable { showDialog.value = true }
    ) {
        Text(
            text = day.dayTitle,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
    if(showDialog.value) {
        Dialog(onDismissRequest = { showDialog.value = false }) {
            BoxWithConstraints(modifier = Modifier
                .padding(20.dp)
                .background(Color.LightGray, RoundedCornerShape(15.dp))
            ) {
                Column(modifier = Modifier
                    .padding(10.dp),
                ) {
                    Text(day.dayTitle,
                        style = TextStyle(
                            fontSize = 38.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Black
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    IconButton(
                        onClick = { /*TODO*/ },
                    ) {
                        Icon(
                            Icons.Default.Add,
                            contentDescription = "добавить новую запись",
                            modifier = Modifier.size(35.dp)
                        )
                    }
                    Divider()
                    Spacer(modifier = Modifier.height(16.dp))
                    LazyColumn(modifier = Modifier.fillMaxWidth()){
                        items(events){event->
                            EventCard(event = event)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun EventCard(event:Event){
    var expanded by remember { mutableStateOf(false)}
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .height(95.dp)
            .clickable { expanded = !expanded }
    ) {
        Column {
            Text(
                text = "oj",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(8.dp)
            )
            if (expanded) {
                Text(
                    text = "gfhgh",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun WeekMonthParameter(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /* Обработка нажатия на стрелку назад */ }) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "Назад")
        }
        Text(
            text = "n неделя / month 2024",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black
        )
        IconButton(onClick = { /* Обработка нажатия на стрелку вперед */ }) {
            Icon(Icons.Filled.ArrowForward, contentDescription = "Вперед")
        }
    }
}


@Preview
@Composable
fun MainPreview(){
    MyApplicationTheme {
        MainScreen(navController = rememberNavController())
    }
}