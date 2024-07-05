@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)

package com.lucas.unitconverterp

import android.graphics.drawable.Drawable
import android.graphics.drawable.Icon
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.lucas.unitconverterp.ui.theme.UnitConverterPTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun MainScreenUnitCategory(navController: NavController, modifier: Modifier = Modifier.background(MaterialTheme.colorScheme.background)) {

    var unitsCategory by remember { mutableStateOf(listOf<String>()) }
    var unitAbreviation by remember { mutableStateOf(listOf<String>()) }
    var unitTitle by remember { mutableStateOf("") }
    var dropdownExpanded by remember { mutableStateOf(false) }
    var searchBar by remember { mutableStateOf("") }
    var wasFavIconClicked by remember { mutableStateOf(true) }


    Scaffold(modifier = modifier
        .fillMaxSize()
        .padding(start = 16.dp, end = 16.dp, top = 16.dp)) {
        Column(modifier = modifier
            .fillMaxSize()
            .padding(it),
            verticalArrangement = Arrangement.spacedBy(25.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically) {

                IconButton(onClick = {navController.navigate("Bookmarks")}, modifier = Modifier.padding(bottom = 2.dp)) {
                    Icon(imageVector = Icons.Default.Star, contentDescription = "Favorites Icon", tint = MaterialTheme.colorScheme.surface,)
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

            Card(modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondary),
                shape = RoundedCornerShape(15.dp),
                onClick = {navController.navigate("SearchScreen")}){
                Row(modifier = Modifier.fillMaxWidth().padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                    Text(text = "Search for units and categories", color = MaterialTheme.colorScheme.surface)
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search icon",
                        modifier = Modifier.clickable {navController.navigate("SearchScreen")},
                        tint = MaterialTheme.colorScheme.surface
                    )
                }
            }
            Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(text = "Common")
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Card(modifier = Modifier
                        .width(100.dp)
                        .height(100.dp),
                        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondary),
                        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                        onClick = {
                            unitsCategory = listOf(
                                "Kilometer", "Meter", "Centimeter",
                                "Millimiter", "Feet")
                            unitTitle = "Length"
                            unitAbreviation = listOf(
                                "km", "m", "cm", "mm", "ft")
                            navController.navigate("UnitCalculator")
                        }
                    ) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                            Column(verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally){
                                Image(painter = painterResource(id = R.drawable.rule_icon), contentDescription = "")
                                Spacer(modifier = Modifier.padding(2.dp))
                                Text(text = "Length", color = MaterialTheme.colorScheme.surface, fontSize = 12.sp)
                            }
                        }
                    }
                    Card(modifier = Modifier
                        .width(100.dp)
                        .height(100.dp),
                        onClick = {
                            unitsCategory = listOf(
                                "Sq.Kilometer", "Sq.Meter", "Sq.Centimeter",
                                "Sq.Millimiter", "Sq.Foot", "Sq.Mile", "Sq.Yard", "Sq.Inch", "Acre", "Hectare")
                            unitTitle = "Area"
                            unitAbreviation = listOf(
                                "km2", "m2", "cm2", "mm2", "mi2",
                                "yd2","ft2", "in2", "ac","ha")
                            navController.navigate("UnitCalculator")
                        },
                        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondary)) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Column(verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally) {
                                Image(painter = painterResource(id = R.drawable.area_icon), contentDescription = "")
                                Spacer(modifier = Modifier.padding(2.dp))
                                Text(text = "Area", color = MaterialTheme.colorScheme.surface, fontSize = 12.sp)
                            }
                        }

                    }
                    Card(modifier = Modifier
                        .width(100.dp)
                        .height(100.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondary),
                        onClick = {
                            unitsCategory = listOf(
                                "Kilogram", "Gram", "Milligram",
                                "Microgram", "Carat", "Tonne",
                                "Pound", "Ounce", "Grain",
                                "Dram", "Stone", "Long Ton",
                                "Short Ton")

                            unitTitle = "Mass"
                            unitAbreviation = listOf(
                                "kg","g", "mg", "ug", "ct", "stone",
                                "t", "lb", "oz", "gr", "dr", "ton", "sh tn")
                            navController.navigate("UnitCalculator")
                        }
                    ){
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                            Column(verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally){
                                Image(painter = painterResource(id = R.drawable.mass_icon), contentDescription = "")
                                Spacer(modifier = Modifier.padding(2.dp))
                                Text(text = "Mass", color = MaterialTheme.colorScheme.surface, fontSize = 12.sp)
                            }
                        }

                    }
                }
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Card(modifier = Modifier
                        .width(100.dp)
                        .height(100.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondary),
                        onClick = {
                            unitsCategory = listOf(
                                "Celsius", "Fahrenheit", "Kelvin",
                                "Rankine")
                            unitTitle = "Temperature"
                            unitAbreviation = listOf(
                                "°C","°F", "K", "R")
                            navController.navigate("UnitCalculator")
                        }
                    ) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                            Column(verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally){
                                Image(painter = painterResource(id = R.drawable.temperature_icon), contentDescription = "")
                                Spacer(modifier = Modifier.padding(2.dp))
                                Text(text = "Temperature", color = MaterialTheme.colorScheme.surface, fontSize = 12.sp)
                            }
                        }


                    }
                    Card(modifier = Modifier
                        .width(100.dp)
                        .height(100.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondary),
                        onClick = {
                            unitsCategory = listOf(
                                "Kilometer/hour", "Meter/sec", "Miles/hour",
                                "Miles/minute", "Miles/sec", "Feet/hour",
                                "Feet/minute", "Feet/secound", "Knot")
                            unitTitle = "Speed"
                            unitAbreviation = listOf(
                                "km/h","m/s", "mi/h", "mi/min", "mi/s", "ft/h", "ft/min", "ft/s", "kn")
                            navController.navigate("UnitCalculator")
                        }
                    ) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                            Column(verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally){
                                Image(painter = painterResource(id = R.drawable.speed_icon), contentDescription = "")
                                Spacer(modifier = Modifier.padding(2.dp))
                                Text(text = "Speed", color = MaterialTheme.colorScheme.surface, fontSize = 12.sp)
                            }
                        }

                    }
                    Card(modifier = Modifier
                        .width(100.dp)
                        .height(100.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondary),
                        onClick = {
                            unitsCategory = listOf(
                                "Liter", "Milliliter", "Centiliter",
                                "Deciliter", "Cubic Meter", "Cubic Centimeter",
                                "Cubic Millimiter")
                            unitTitle = "Volume"
                            unitAbreviation = listOf(
                                "L","mL", "cL", "dL", "m3", "cm3", "mm3")
                            navController.navigate("UnitCalculator")
                        }
                    ) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                            Column(verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally){
                                Image(painter = painterResource(id = R.drawable.volume_icon), contentDescription = "")
                                Spacer(modifier = Modifier.padding(2.dp))
                                Text(text = "Volume", color = MaterialTheme.colorScheme.surface, fontSize = 12.sp)
                            }
                        }

                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Preview(showBackground = true)
@Composable
fun MainScreenUnitCategoryPreview() {
    UnitConverterPTheme {
        val navController = rememberAnimatedNavController()
        MainScreenUnitCategory(navController)
    }
}