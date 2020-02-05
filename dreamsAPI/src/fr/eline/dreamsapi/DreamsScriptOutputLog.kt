package fr.eline.dreamsapi

import java.text.SimpleDateFormat
import java.util.*

// Author: Nourredine OCTEAU
// éline Technologies 2020

private var DreamsScriptOutput: String = ""

fun getDreamsScriptOutput(): String {
    return DreamsScriptOutput
}

fun addLogError(message: String){
    val msg = "ERROR ${message}"
    DreamsScriptOutput += "${msg}\n"
    val ft = SimpleDateFormat ("yyyy.MM.dd hh:mm:ss.S");
    println("${ft.format(Date())} $msg")
}

fun addLogWarning(message: String){
    val msg = "WARNING ${message}"
    DreamsScriptOutput += "${msg}\n"
    val ft = SimpleDateFormat ("yyyy.MM.dd hh:mm:ss.S");
    println("${ft.format(Date())} $msg")
}

fun addLogInfo(message: String){
    val msg = "INFO ${message}"
    DreamsScriptOutput += "${msg}\n"
    val ft = SimpleDateFormat ("yyyy.MM.dd hh:mm:ss.S");
    println("${ft.format(Date())} $msg")
}

fun addLogDebug(message: String){
    val msg = "DEBUG ${message}"
    DreamsScriptOutput += "${msg}\n"
    val ft = SimpleDateFormat ("yyyy.MM.dd hh:mm:ss.S");
    println("${ft.format(Date())} $msg")
}