@file:OptIn(ExperimentalMaterial3Api::class)

package com.lucas.unitconverterp.ui.screens.setting_screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.lucas.unitconverterp.ui.theme.ColorFontSettingsPage

@OptIn(ExperimentalMaterial3Api::class)
@Composable


fun SettingsScreenLayout(navController:NavController, modifier: Modifier = Modifier.background(MaterialTheme.colorScheme.background)) {

    var isThemeDialog by remember { mutableStateOf(false) }
    var selectedTheme by remember { mutableStateOf(false) }
    var checkedSwitchVibration by remember { mutableStateOf(false) }
    var selectedOptionThemeDescription by remember { mutableStateOf("") }


    
    Scaffold(modifier = modifier
        .fillMaxSize()
        .padding(start = 16.dp, end = 16.dp, top = 16.dp)) {
        Column(modifier = modifier.padding(it)) {
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.fillMaxWidth())
            {
                IconButton(onClick = {navController.navigate("MainScreen")})
                {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                }
                Text(text = "Settings", fontSize = 25.sp, color = MaterialTheme.colorScheme.surface)
            }

            Spacer(modifier = Modifier.padding(20.dp))

            Text(text = "Apperance",
                fontWeight = FontWeight.Bold,
                color = ColorFontSettingsPage,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 58.dp))

            Spacer(modifier = Modifier.padding(8.dp))

            Card(modifier = Modifier
                .fillMaxWidth().height(46.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                onClick = {isThemeDialog = true})
            {
                    Box() {
                        Column(modifier = Modifier.padding(start = 58.dp).fillMaxWidth())
                        {
                            Text(text = "Theme", fontSize = 18.sp, color = MaterialTheme.colorScheme.surface)
                            Text(text = selectedOptionThemeDescription,
                                fontSize = 14.sp,
                                color = ColorFontSettingsPage,
                                style = TextStyle(shadow = Shadow(color = Color.Black, offset = Offset(0.2f, 0.2f), blurRadius = 0.5f)))
                        }
                    }
                }

            Spacer(modifier = Modifier.padding(8.dp))

            Card(modifier = Modifier.fillMaxWidth().height(46.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                onClick = {})
            {
                Box() {
                    Row(horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(bottom = 8.dp))
                    {
                        Column(modifier = Modifier.padding(start = 58.dp))
                        {
                            Text(text = "Vibrations",fontSize = 18.sp,color = MaterialTheme.colorScheme.surface)
                            Text(text = "Enable vibrations on button press",
                                fontSize = 14.sp, color = ColorFontSettingsPage,
                                style = TextStyle(shadow = Shadow(color = Color.Black,offset = Offset(0.2f, 0.2f),blurRadius = 0.5f)))}

                        Spacer(modifier = Modifier.padding(8.dp))

                        Column(modifier = Modifier.fillMaxWidth().scale(scale = 0.7f),
                            horizontalAlignment = Alignment.End)
                        {
                            Switch(checked = checkedSwitchVibration, onCheckedChange = {
                                if(checkedSwitchVibration){
                                    checkedSwitchVibration = false
                                }else{
                                    checkedSwitchVibration = true
                                }
                            })
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.padding(8.dp))

            Divider()

            Spacer(modifier = Modifier.padding(8.dp))

            Text(text = "About",
                fontWeight = FontWeight.Bold,
                color = ColorFontSettingsPage,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 58.dp))

            Spacer(modifier = Modifier.padding(8.dp))

            Card(modifier = Modifier.fillMaxWidth().height(46.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                onClick = {})
            {
                Box() {
                    Column(modifier = Modifier.padding(start = 58.dp).fillMaxWidth())
                    {
                        Text(text = "Version", fontSize = 18.sp, color = MaterialTheme.colorScheme.surface)
                        Text(text = "0.1-Alpa",
                            fontSize = 14.sp,
                            color = ColorFontSettingsPage,
                            style = TextStyle(shadow = Shadow(color = Color.Black, offset = Offset(0.2f, 0.2f), blurRadius = 0.5f)))
                    }
                }
            }

            Spacer(modifier = Modifier.padding(8.dp))

            Card(modifier = Modifier.fillMaxWidth().height(46.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                onClick = {})
            {
                Box() {
                    Column(modifier = Modifier.padding(start = 58.dp).fillMaxWidth())
                    {
                        Text(text = "Terms of Use", fontSize = 18.sp, color = MaterialTheme.colorScheme.surface)
                    }
                }
            }

            Spacer(modifier = Modifier.padding(8.dp))

            Card(modifier = Modifier.fillMaxWidth().height(46.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                onClick = {})
            {
                Box(){
                    Column(modifier = Modifier.padding(start = 58.dp).fillMaxWidth())
                    {
                        Text(text = "Third Party Notices", fontSize = 18.sp, color = MaterialTheme.colorScheme.surface)
                    }
                }
            }

            Spacer(modifier = Modifier.padding(8.dp))

            Card(modifier = Modifier.fillMaxWidth().height(46.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                onClick = {})
            {
                Box(){
                    Column(modifier = Modifier.padding(start = 58.dp).fillMaxWidth())
                    {
                        Text(text = "Rate this app", fontSize = 18.sp, color = MaterialTheme.colorScheme.surface)
                    }
                }
            }
        }
        if(isThemeDialog){
            AlertDialog(onDismissRequest = {}, modifier = Modifier.clip(RoundedCornerShape(8.dp)).background(MaterialTheme.colorScheme.background))
            {
                Column(modifier = Modifier.padding(16.dp).fillMaxWidth())
                {
                    Text(text = "Theme", fontSize = 20.sp, color = MaterialTheme.colorScheme.surface)

                    Spacer(modifier = Modifier.padding(8.dp))

                    Row(verticalAlignment = Alignment.CenterVertically)
                    {
                        RadioButton(selected = selectedTheme,
                            onClick = {
                                selectedTheme = true
                                isThemeDialog = false
                                selectedOptionThemeDescription = "Light"})
                        Text(text = "Light", fontSize = 18.sp, color = MaterialTheme.colorScheme.surface)
                    }
                    Row(verticalAlignment = Alignment.CenterVertically)
                    {
                        RadioButton(selected = selectedTheme,
                            onClick = {
                                selectedTheme = true
                                isThemeDialog = false
                                selectedOptionThemeDescription = "Dark"})
                        Text(text = "Dark", fontSize = 18.sp, color = MaterialTheme.colorScheme.surface)
                    }
                    Row(verticalAlignment = Alignment.CenterVertically)
                    {
                        RadioButton(selected = selectedTheme,
                            onClick = {
                                selectedTheme = true
                                isThemeDialog = false
                                selectedOptionThemeDescription = "System Default"
                            })
                        Text(text = "System Default", fontSize = 18.sp, color = MaterialTheme.colorScheme.surface)
                    }
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                        TextButton(onClick = {isThemeDialog = false}) {
                            Text(text = "Cancel", fontSize = 16.sp, color = MaterialTheme.colorScheme.surface)
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
fun SettingsScreenLayoutPreview(){
    val navController = rememberAnimatedNavController()
    SettingsScreenLayout(navController)
}