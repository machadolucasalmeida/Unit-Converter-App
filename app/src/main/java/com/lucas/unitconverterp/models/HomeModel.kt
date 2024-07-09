package com.lucas.unitconverterp.models

import com.lucas.unitconverterp.ui.screens.home_screen.HomeViewModel

data class HomeModel(
    var unitCategory:List<String>,
    var titleCategory:String,
    var unitAbreviation:List<String>
)

class HomeRepository(){
    private var _infoCategory = HomeModel(unitCategory = listOf<String>(), titleCategory = "", unitAbreviation = listOf<String>())
    fun getInfo() = _infoCategory

}
