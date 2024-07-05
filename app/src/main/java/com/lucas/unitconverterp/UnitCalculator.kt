@file:OptIn(ExperimentalAnimationApi::class)

package com.lucas.unitconverterp

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ChipBorder
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
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnitCalculatorDesign(navController:NavController, modifier: Modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
    //Layout Settings
    val scrollState = rememberScrollState()
    val buttonSizeHeight = 70.dp
    val buttonSizeWidth = 85.dp
    val specialButtonSizeHeight = 150.dp
    val specialButtonSizeWidth = 85.dp
    val roundedCornerButton = 25.dp
    val fontSizeButton = 30.sp
    val swapLogoThemeChange = if(isSystemInDarkTheme()){R.drawable.swap_dark_icon}else{R.drawable.swap_icon}
    val copyLogoThemeChange = if(isSystemInDarkTheme()){R.drawable.copy_dark_icon}else{R.drawable.copy_icon}
    val calculatorLogoThemeChange = if(isSystemInDarkTheme()){R.drawable.calculator_dark_icon}else{R.drawable.calculator_icon}
    val expandLogoThemeChange = if(isSystemInDarkTheme()){R.drawable.expand_dark_icon}else{R.drawable.expand_icon}

    var dropdownExpanded by remember { mutableStateOf(false) }

    //Setting functionality








    Scaffold(modifier = modifier
        .fillMaxSize()
        .padding(8.dp)){
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column() {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),horizontalArrangement = Arrangement.SpaceBetween,verticalAlignment = Alignment.CenterVertically) {
                    Row(verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        IconButton(onClick = {navController.navigate("MainScreen")}) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Go back icon", tint = MaterialTheme.colorScheme.surface)
                        }
                        Text(text = "unitTitle", fontSize = 25.sp, color = MaterialTheme.colorScheme.surface)
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(painter = painterResource(id = expandLogoThemeChange),contentDescription = "")
                        //Image(painter = painterResource(id = R.drawable.unexpand_icon), contentDescription = "")
                        IconButton(onClick = {navController.navigate("Bookmarks")}, modifier = Modifier.padding(bottom = 2.dp)) {
                            Icon(imageVector = Icons.Default.Star, contentDescription = "Favorites Icon", tint = MaterialTheme.colorScheme.surface)
                        }
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
                Spacer(modifier = Modifier.padding(20.dp))
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface)) {
                        Row(modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 20.dp, end = 20.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                            Row(modifier = Modifier.padding(bottom = 25.dp)) {
                                Text(text = "Meter", color = MaterialTheme.colorScheme.primary, fontSize = 18.sp)
                                Icon(imageVector = Icons.Default.ArrowDropDown,contentDescription = "Arrow Dropdown",tint = MaterialTheme.colorScheme.primary)}
                            Row(horizontalArrangement = Arrangement.spacedBy(5.dp),verticalAlignment = Alignment.CenterVertically,modifier = Modifier.padding(top = 25.dp)) {
                                Text(text = "0", color = MaterialTheme.colorScheme.surface, fontSize = 30.sp)
                                Box(modifier = Modifier
                                    .background(
                                        MaterialTheme.colorScheme.primary,
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .padding(horizontal = 16.dp, vertical = 1.dp)
                                ){
                                    Text(text = "Mt",fontSize = 16.sp,color = Color.White)
                                }
                            }
                        }
                    }
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface)) {
                        Row(modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 20.dp, end = 20.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                            Row(modifier = Modifier.padding(bottom = 25.dp)) {
                                Text(text = "Meter", color = MaterialTheme.colorScheme.primary, fontSize = 18.sp)
                                Icon(imageVector = Icons.Default.ArrowDropDown,contentDescription = "Arrow Dropdown",tint = MaterialTheme.colorScheme.primary)}
                            Row(horizontalArrangement = Arrangement.spacedBy(5.dp),verticalAlignment = Alignment.CenterVertically,modifier = Modifier.padding(top = 25.dp)) {
                                Text(text = "0", color = MaterialTheme.colorScheme.surface, fontSize = 30.sp)
                                Box(modifier = Modifier
                                    .background(
                                        MaterialTheme.colorScheme.primary,
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .padding(horizontal = 16.dp, vertical = 1.dp)
                                ){
                                    Text(text = "Mt",fontSize = 16.sp,color = Color.White)
                                }
                            }
                        }
                    }
                }
            }
            Column(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp)) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(scrollState),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)){
                    AssistChip(
                        onClick = { /*TODO*/ },
                        label = {
                            Icon(imageVector = Icons.Default.Star,contentDescription = "", modifier = Modifier.size(22.dp), tint = MaterialTheme.colorScheme.surface)
                            Spacer(modifier = Modifier.padding(2.dp))
                            Text(text = "Save to bookmarks", fontSize = 16.sp, color = MaterialTheme.colorScheme.surface)})
                    AssistChip(
                        onClick = { /*TODO*/ },
                        label = {
                            Image(painter = painterResource(id = swapLogoThemeChange), contentDescription = "")
                            Spacer(modifier = Modifier.padding(2.dp))
                            Text(text = "Swap units", fontSize = 16.sp, color = MaterialTheme.colorScheme.surface)}
                    )
                    AssistChip(
                        onClick = { /*TODO*/ },
                        label = {
                            Image(painter = painterResource(id = copyLogoThemeChange), contentDescription = "")
                            Spacer(modifier = Modifier.padding(2.dp))
                            Text(text = "Copy result", fontSize = 16.sp, color = MaterialTheme.colorScheme.surface)})
                    AssistChip(
                        onClick = {navController.navigate("CalculatorScreen")},
                        label = {
                            Image(painter = painterResource(id = calculatorLogoThemeChange), contentDescription = "")
                            Spacer(modifier = Modifier.padding(2.dp))
                            Text(text = "Open calculator", fontSize = 16.sp, color = MaterialTheme.colorScheme.surface)})
                }
                Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Column (verticalArrangement = Arrangement.spacedBy(10.dp)){
                        Row (horizontalArrangement = Arrangement.spacedBy(10.dp)){
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface)){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "7", fontSize = fontSizeButton, color = MaterialTheme.colorScheme.surface)
                                }

                            }
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface)){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "8", fontSize = fontSizeButton, color = MaterialTheme.colorScheme.surface)
                                }

                            }
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface)){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "9", fontSize = fontSizeButton, color = MaterialTheme.colorScheme.surface)
                                }

                            }
                        }
                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface)){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "4", fontSize = fontSizeButton, color = MaterialTheme.colorScheme.surface)
                                }

                            }
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface)){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "5", fontSize = fontSizeButton, color = MaterialTheme.colorScheme.surface)
                                }

                            }
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface)){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "6", fontSize = fontSizeButton, color = MaterialTheme.colorScheme.surface)
                                }

                            }
                        }
                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface)){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "1", fontSize = fontSizeButton, color = MaterialTheme.colorScheme.surface)
                                }

                            }
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface)){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "2", fontSize = fontSizeButton, color = MaterialTheme.colorScheme.surface)
                                }

                            }
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface)){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "3", fontSize = fontSizeButton, color = MaterialTheme.colorScheme.surface)
                                }

                            }
                        }
                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface)){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "+/-", fontSize = fontSizeButton, color = MaterialTheme.colorScheme.surface)
                                }

                            }
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface)){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = "0", fontSize = fontSizeButton, color = MaterialTheme.colorScheme.surface)
                                }

                            }
                            Card(modifier = Modifier
                                .height(buttonSizeHeight)
                                .width(buttonSizeWidth)
                                .clip(shape = RoundedCornerShape(roundedCornerButton)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface)){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Text(text = ".", fontSize = fontSizeButton, color = MaterialTheme.colorScheme.surface)
                                }

                            }
                        }
                    }
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Card(modifier = Modifier
                            .height(specialButtonSizeHeight)
                            .width(specialButtonSizeWidth)
                            .clip(shape = RoundedCornerShape(roundedCornerButton)),
                            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary)){
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                Image(painter = painterResource(id = R.drawable.delete_icon), contentDescription = "")
                            }

                        }
                        Card(modifier = Modifier
                            .height(specialButtonSizeHeight)
                            .width(specialButtonSizeWidth)
                            .clip(shape = RoundedCornerShape(roundedCornerButton)),
                            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary)){
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                Text(text = "A/C", fontSize = fontSizeButton, color = Color.White)
                            }

                        }
                    }
                }
            }
        }
    }

}

@Preview
@Composable
fun UnitCalculatorDesignPreview() {
    val navController = rememberAnimatedNavController()
    UnitCalculatorDesign(navController)
}