package com.lucas.unitconverterp

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ChipElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreenLayout(navController:NavController, modifier: Modifier = Modifier.background(MaterialTheme.colorScheme.background)) {

    var searchText by remember { mutableStateOf("")}



    Scaffold(modifier = modifier
        .fillMaxSize()
        .padding(start = 16.dp, end = 16.dp, top = 16.dp)){
        Column(modifier = modifier.padding(it)){
            Column(verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()){
                IconButton(onClick = {navController.navigate("MainScreen")}){
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                }
            }
            Column(){
                OutlinedTextField(
                value = searchText,
                singleLine = true,
                onValueChange = {searchText = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 22.dp),
                placeholder = { Text(text = "Search for units and categories", color = MaterialTheme.colorScheme.surface)},
                shape = RoundedCornerShape(15.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent,
                    errorBorderColor = Color.Transparent,
                    disabledBorderColor = Color.Transparent,
                    focusedTextColor = MaterialTheme.colorScheme.surface,
                    unfocusedTextColor = MaterialTheme.colorScheme.surface
                ))

                Text(text = "Popular Searches", fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp), color = MaterialTheme.colorScheme.surface)

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                    AssistChip(onClick = {navController.navigate("UnitCalculator")}, label = { Text(text = "Meter", color = MaterialTheme.colorScheme.surface)})
                    AssistChip(onClick = {navController.navigate("UnitCalculator")}, label = { Text(text = "Kilogram", color = MaterialTheme.colorScheme.surface)})
                    AssistChip(onClick = {navController.navigate("UnitCalculator")}, label = {Text(text = "Sq.Foot", color = MaterialTheme.colorScheme.surface)})
                }
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                    AssistChip(onClick = {navController.navigate("UnitCalculator")}, label = { Text(text = "Miles/hour", color = MaterialTheme.colorScheme.surface)})
                    AssistChip(onClick = {navController.navigate("UnitCalculator")}, label = { Text(text = "Fahrenheit", color = MaterialTheme.colorScheme.surface)})
                    AssistChip(onClick = {navController.navigate("UnitCalculator")}, label = {Text(text = "Kilocalorie", color = MaterialTheme.colorScheme.surface)})
                    }
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                    AssistChip(onClick = {navController.navigate("UnitCalculator")}, label = { Text(text = "Hertz", color = MaterialTheme.colorScheme.surface)})
                    AssistChip(onClick = {navController.navigate("UnitCalculator")}, label = { Text(text = "Megabyte", color = MaterialTheme.colorScheme.surface)})
                    AssistChip(onClick = {navController.navigate("UnitCalculator")}, label = {Text(text = "Newton", color = MaterialTheme.colorScheme.surface)})
                    }
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                    AssistChip(onClick = {navController.navigate("UnitCalculator")}, label = { Text(text = "Watt", color = MaterialTheme.colorScheme.surface)})
                    AssistChip(onClick = {navController.navigate("UnitCalculator")}, label = { Text(text = "Ampere", color = MaterialTheme.colorScheme.surface)})
                    AssistChip(onClick = {navController.navigate("UnitCalculator")}, label = {Text(text = "Pound", color = MaterialTheme.colorScheme.surface)})
                    }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun SearchScreenLayoutPreview(){
    val navController = rememberAnimatedNavController()
    SearchScreenLayout(navController)
}