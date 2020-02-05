package fr.eline.dreamsapi

import kotlin.collections.ArrayList

// Author: Nourredine OCTEAU
// éline Technologies 2020

class DreamsScript(val name: String, val packagePath: String) {

    val scriptParameters: ArrayList<DreamsScriptParameter> = ArrayList<DreamsScriptParameter>()

    fun loadFromJson(jsonScript: Map<String, Any>){
        addLogInfo("loading ${packagePath}.${name} script...")
        loadAllScriptParams(jsonScript["params"] as ArrayList<Map<String, Any>>)
    }

    private fun loadAllScriptParams(allParams: ArrayList<Map<String, Any>>){
        for(param in allParams){
            val p = DreamsScriptParameter(param["name"] as String, param["type"] as String, param["scope"] as String, param["value"] as Any)
            scriptParameters.add(p)
            addLogDebug("Loaded script parameter : ${p.scope} ${p.type} ${p.name} = ${p.value}")
        }
    }

    fun exec() {
        addLogDebug("test")
    }

}