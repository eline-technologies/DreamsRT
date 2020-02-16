package fr.eline.dreamsapi

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

// Author: Nourredine OCTEAU
// éline Technologies 2020

class DreamsScriptLoader {

    fun loadScript(scriptFilename: String) : DreamsScript? {
        val file = File(scriptFilename)
        try {
            val jsonText = file.readText()
            val scriptFile = Gson().fromJson(jsonText, DreamsScriptFile::class.java)
            val script = DreamsScript(scriptFile.name, scriptFile.packagePath)
            script.loadFromJson(scriptFile)
            return script;
        }
        catch (ex: Exception) {
            return null
        }
    }

}