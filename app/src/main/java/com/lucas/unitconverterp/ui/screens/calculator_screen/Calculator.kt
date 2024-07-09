package com.lucas.unitconverterp.ui.screens.calculator_screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import androidx.navigation.NavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.lucas.unitconverterp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorLayout(navController: NavController, modifier: Modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
    //Layout Settings
    val scrollState = rememberScrollState()
    val buttonSizeHeight = 70.dp
    val buttonSizeWidth = 85.dp
    val specialButtonSizeHeight = 150.dp
    val specialButtonSizeWidth = 85.dp
    val roundedCornerButton = 25.dp
    val fontSizeButton = 30.sp
    val deleteIconChange = if(isSystemInDarkTheme()){
        R.drawable.delete_icon
    }else{
        R.drawable.delete_light_icon
    }
    var dropdownExpanded by remember { mutableStateOf(false) }

    //Functionality
    var displayText by remember{ mutableStateOf("") }
    var resultText by remember{ mutableStateOf("") }




    Scaffold(modifier = modifier
        .fillMaxSize()
        .padding(8.dp)){
        Column(modifier = modifier.padding(it)){
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()){
                Row {
                    IconButton(onClick = {navController.navigate("MainScreen")}) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Go back icon", tint = MaterialTheme.colorScheme.surface)
                    }
                    Text(text = "Calculator", fontSize = 25.sp, color = MaterialTheme.colorScheme.surface)
                }
                Row {
                    Box(){
                        Card(colors = CardDefaults.cardColors(Color.Transparent),
                            onClick = {
                                dropdownExpanded = true
                            }
                        ){
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "More Information Icon",
                                tint = MaterialTheme.colorScheme.surface)
                        }
                        DropdownMenu(expanded = dropdownExpanded, onDismissRequest = {dropdownExpanded = false},
                            modifier = Modifier.background(MaterialTheme.colorScheme.secondary), properties = PopupProperties(focusable = true)
                        ) {
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = "Settings",
                                        color = MaterialTheme.colorScheme.surface)
                                },
                                onClick = {
                                    navController.navigate("SettingsScreen")
                                    dropdownExpanded = false
                                }
                            )
                        }
                    }
                }

            }
            Column {
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface)) {
                    Row(modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 20.dp, end = 20.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Column(verticalArrangement = Arrangement.Bottom, modifier = Modifier
                            .fillMaxHeight()
                            .padding(bottom = 16.dp)){
                            Button(onClick = { /*TODO*/ }) {
                                Image(painter = painterResource(id = R.drawable.history_dark_icon), contentDescription = "")
                                Spacer(modifier = Modifier.padding(3.dp))
                                Text(text = "History", color = Color.White)
                            }
                        }
                        Column(verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxHeight()){
                            Text(text = "5+5", color = MaterialTheme.colorScheme.surface, fontSize = 30.sp, maxLines = 2)
                            Text(text = "10", color = MaterialTheme.colorScheme.surface, fontSize = 24.sp,modifier = Modifier.align(Alignment.End))
                        }
                    }
                }
            }
            Column{
                Row(modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 8.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Bottom) {
                    Column (verticalArrangement = Arrangement.spacedBy(10.dp)){
                        Row (horizontalArrangement = Arrangement.spacedBy(10.dp)){
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
                                onClick = {}
                            ){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "AC", fontSize = fontSizeButton, color = Color.White)
                                }

                            }
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary)){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "( )", fontSize = fontSizeButton, color = Color.White)
                                }

                            }
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
                                onClick = {}
                            ){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "%", fontSize = fontSizeButton, color = Color.White)
                                }

                            }
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
                                onClick = {}
                            ){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "÷", fontSize = fontSizeButton, color = Color.White)
                                }

                            }
                        }
                        Row (horizontalArrangement = Arrangement.spacedBy(10.dp)){
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface),
                                onClick = {}
                            ){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "7", fontSize = fontSizeButton, color = MaterialTheme.colorScheme.surface)
                                }

                            }
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface),
                                onClick = {}
                            ){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "8", fontSize = fontSizeButton, color = MaterialTheme.colorScheme.surface)
                                }

                            }
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface),
                                onClick = {}
                            ){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "9", fontSize = fontSizeButton, color = MaterialTheme.colorScheme.surface)
                                }

                            }
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
                                onClick = {}
                            ){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "X", fontSize = fontSizeButton, color = Color.White)
                                }

                            }

                        }
                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface),
                                onClick = {}
                            ){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "4", fontSize = fontSizeButton, color = MaterialTheme.colorScheme.surface)
                                }

                            }
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface),
                                onClick = {}
                            ){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "5", fontSize = fontSizeButton, color = MaterialTheme.colorScheme.surface)
                                }

                            }
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface),
                                onClick = {}
                            ){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "6", fontSize = fontSizeButton, color = MaterialTheme.colorScheme.surface)
                                }

                            }
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
                                onClick = {}
                            ){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "-", fontSize = fontSizeButton, color = Color.White)
                                }

                            }
                        }
                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface),
                                onClick = {}
                            ){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "1", fontSize = fontSizeButton, color = MaterialTheme.colorScheme.surface)
                                }

                            }
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface),
                                onClick = {}
                            ){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "2", fontSize = fontSizeButton, color = MaterialTheme.colorScheme.surface)
                                }

                            }
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface),
                                onClick = {}
                            ){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "3", fontSize = fontSizeButton, color = MaterialTheme.colorScheme.surface)
                                }
                            }
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
                                onClick = {}
                            ){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "+", fontSize = fontSizeButton, color = Color.White)
                                }

                            }
                        }
                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface),
                                onClick = {}
                            ){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = ".", fontSize = fontSizeButton, color = MaterialTheme.colorScheme.surface)
                                }

                            }
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface),
                                onClick = {}
                            ){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "0", fontSize = fontSizeButton, color = MaterialTheme.colorScheme.surface)
                                }
                            }
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface),
                                onClick = {}
                            ){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Image(painter = painterResource(id = deleteIconChange), contentDescription = "")
                                }
                            }
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
                                onClick = {}
                            ){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "=", fontSize = fontSizeButton, color = Color.White)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun CalculatorLayoutPreview() {
    val navController = rememberAnimatedNavController()
    CalculatorLayout(navController)
}