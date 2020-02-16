package fr.eline.dreamsapi

import kotlin.collections.ArrayList

// Author: Nourredine OCTEAU
// éline Technologies 2020

class DreamsScript(val name: String, val packagePath: String) {

    val scriptParameters: ArrayList<DreamsScriptParameter> = ArrayList()

    val scriptMethods: ArrayList<DreamsScriptMethod> = ArrayList()

    fun loadFromJson(dreamsScriptFile: DreamsScriptFile){
        addLogInfo("loading ${packagePath}.${name} script...")
        loadAllScriptParams(dreamsScriptFile.params)
        loadAllScriptMethods(dreamsScriptFile.methods)
    }

    private fun loadAllScriptParams(allParams: List<DreamsScriptParameter>){
        for(param in allParams){
            scriptParameters.add(param)
            addLogDebug("Loaded script parameter: ${param.scope} ${param.type} ${param.name} = ${param.value}")
        }
    }

    private fun loadAllScriptMethods(allMethods: List<DreamsScriptMethod>){
        for(method in allMethods){
            method.loadNodes()
            scriptMethods.add(method)
            addLogDebug("Loaded script method: ${method.name}")
        }
    }

    fun exec(): Int {
        val initMethod = scriptMethods.firstOrNull { it.name == "#_init" }
        if (initMethod != null) {
            return initMethod.exec(this)
        }
        else {
            return -1;
        }
    }

}