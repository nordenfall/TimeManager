package com.example.myapplication.view.eventScreens
import android.app.Application
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.viewModel.MainViewModel
import com.example.myapplication.viewModel.MainViewModelFactory
import com.example.myapplication.navigation.eventsNavigation.NavRoute
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.utils.TYPE_ROOM


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(navController: NavHostController){
    val context = LocalContext.current
    val mViewModel:MainViewModel = viewModel(factory = MainViewModelFactory(context.applicationContext as Application))

    var textLogin by remember { mutableStateOf("") }
    var textPassword by remember { mutableStateOf("") }
    val maxLoginLength = 10
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = TextFieldValue(textLogin),
                onValueChange = { newValue ->
                    if (newValue.text.length > maxLoginLength) {
                        newValue.copy(text = newValue.text.take(maxLoginLength)) //
                    } else {
                        textLogin = newValue.text
                    }
                },
                label = { Text(text = "Логин")},
                singleLine = true,
                maxLines = 1,
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = colorResource(id = R.color.dark_gray),
                    containerColor = Color.White,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = colorResource(id = R.color.dark_gray)
                ),
                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 10.dp)
            )
            OutlinedTextField(
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = colorResource(id = R.color.dark_gray),
                    containerColor = Color.White,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = colorResource(id = R.color.dark_gray)
                ),
                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 10.dp),
                value = TextFieldValue(textPassword),
                onValueChange = {newValue ->
                    textPassword = newValue.text
                },
                label = { Text("Пароль") },
                singleLine = true,
                maxLines = 1,
                visualTransformation = PasswordVisualTransformation(),

            )
            Button(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .size(100.dp, 40.dp)
                    .shadow(6.dp, RoundedCornerShape(50))
                    .padding(1.dp),
                onClick = {
                    navController.navigate(NavRoute.MainScreen.route)
                    mViewModel.initDatabase(TYPE_ROOM)
                          },
                interactionSource = interactionSource,
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isPressed) colorResource(id = R.color.light_green)
                    else colorResource(id = R.color.dark_gray))
            ) {
                Text("Вход")
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun StartPreview(){
    MyApplicationTheme {
        StartScreen(navController = rememberNavController())
    }
}
