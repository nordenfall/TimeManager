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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Text
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.AnnotatedString
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
            Spacer(modifier = Modifier.height(50.dp))
            menuItems.forEachIndexed() { index, item ->
                Column(
                    modifier = Modifier.padding(8.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp)
                            .clickable { navController.navigate(item.route) }
                            .size(100.dp),

                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(30.dp)
                        ){
                            Row() {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.name,
                                    tint = Color.Black,
                                    modifier = Modifier.size(45.dp)
                                )
                                Spacer(modifier = Modifier.width(20.dp))
                                Text(
                                    text = AnnotatedString(item.name),
                                    style = TextStyle(
                                        fontSize = 30.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black

                                    )
                                )
                            }
                        }

                    }
                }

                if (index < menuItems.size - 1) {
                    Divider(color = colorResource(id = R.color.dark_gray),
                        modifier = Modifier.padding(15.dp)
                    )
                }
            }
        }
    }
}
data class MenuItem(val route:String, val icon:ImageVector, val name:String)

val menuItems = listOf(
    MenuItem(route = "main_screen", icon = Icons.Default.DateRange, "Расписание"),
    MenuItem(route = "profile_screen", icon = Icons.Default.AccountCircle, "Профиль"),
    MenuItem(route = "tag_screen", icon = Icons.Default.Create, "Теги")
)



@Preview(showBackground = true)
@Composable
fun MenuPreview(){
    MyApplicationTheme {
        MenuScreen(navController = rememberNavController())
    }
}