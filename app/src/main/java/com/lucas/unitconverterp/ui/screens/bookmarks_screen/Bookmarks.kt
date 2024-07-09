package com.lucas.unitconverterp.ui.screens.bookmarks_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun BookmarksLayoutScreen(navController: NavController ,modifier: Modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
    Scaffold(modifier = modifier
        .fillMaxSize()
        .padding(start = 16.dp, end = 16.dp, top = 16.dp)){
        Column(modifier = modifier.padding(it)) {
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.fillMaxWidth()){
                IconButton(onClick = {navController.navigate("MainScreen")}){
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                }
                Text(text = "Bookmarks", fontSize = 25.sp, color = MaterialTheme.colorScheme.surface)
            }
        }
    }
}