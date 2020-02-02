package fr.eline.dreamsapi

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

// Author: Nourredine OCTEAU
// éline Technologies 2020

class DreamsScriptInterpreter {

    fun loadScript(scriptFilename: String) : DreamsScript? {
        val file = File(scriptFilename)
        try {
            val jsonText = file.readText()
            val type = object : TypeToken<Map<String, Any>>() {}.type
            val scriptJson: Map<String, Any> = Gson().fromJson(jsonText, type)
            return DreamsScript(scriptJson["name"] as String, scriptJson["package"] as String);
        }
        catch (ex: Exception){
            return null
        }
    }

}