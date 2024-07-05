package com.lucas.unitconverterp

open class CalculatorOperations(val symbol: String) {
    object Add: CalculatorOperations("+")
    object Subtract: CalculatorOperations("-")
    object Multiply: CalculatorOperations("x")
    object Divide: CalculatorOperations("÷")
    object Percentage: CalculatorOperations("%")
}