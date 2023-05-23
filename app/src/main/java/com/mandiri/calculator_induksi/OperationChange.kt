package com.mandiri.calculator_induksi

import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

interface OperationChange {
    fun addToOperation(currentOperation: String, newOperation: String): String{
        return "$currentOperation$newOperation"
    }

    fun deleteLastOperation(currentOperation: String): String{
        var deletedOperation = ""
        var x: Char = 'A'
        for (i in 0..currentOperation.length-2){
            x = currentOperation[i]
            deletedOperation = "$deletedOperation$x"
        }
        return deletedOperation
    }
    fun getInputOperation(currentOperation: String): String {
        var operation = currentOperation.replace(Regex("÷"), "/")
        operation = operation.replace(Regex("×"), "*")
        return operation
    }

    fun getResult(currentOperation: String): String{
        try {
            val fulloperation = getInputOperation(currentOperation)
            val result = Expression(fulloperation).calculate()

            if (result.isNaN()){
                return "Error Nan"
            }
            else{
                return "${DecimalFormat("0.######").format(result).toString()}"
            }
        } catch (e: Exception){
            return "Error"
        }
    }
}