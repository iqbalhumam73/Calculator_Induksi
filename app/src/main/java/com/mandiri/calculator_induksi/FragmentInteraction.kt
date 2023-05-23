package com.mandiri.calculator_induksi

interface FragmentInteraction {
    fun tvOperationChange(newOperationValue: String)
    fun tvResultChange(result: String)
    fun getTvOperation(): String
    fun getResult(): String
}