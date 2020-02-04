package fr.eline.dreamsapi

// Author: Nourredine OCTEAU
// éline Technologies 2020

class DreamsScript(val name: String, val packagePath: String) {

    fun loadFromJson(jsonScript: Map<String, Any>){
        addLogInfo("loading ${packagePath}.${name} script...")
    }

    fun exec() {
        addLogDebug("test")
    }

}