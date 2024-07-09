package com.lucas.unitconverterp.ui.screens.home_screen

import android.view.View
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import com.lucas.unitconverterp.models.HomeModel
import com.lucas.unitconverterp.models.HomeRepository

class HomeViewModel():ViewModel() {
    private val _repository : HomeRepository = HomeRepository()
    val infoRepository = _repository


}