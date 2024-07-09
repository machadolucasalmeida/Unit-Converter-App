package com.lucas.unitconverterp.ui.screens.unitconverter_screen

import androidx.lifecycle.ViewModel
import com.lucas.unitconverterp.models.HomeRepository

class UnitConverterViewModel() :ViewModel(){
    private val _repository:HomeRepository = HomeRepository()
    val repoInfo = _repository
}