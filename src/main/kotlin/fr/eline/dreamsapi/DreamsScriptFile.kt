package fr.eline.dreamsapi

import com.google.gson.annotations.SerializedName

// Author: Nourredine OCTEAU
// éline Technologies 2020

data class DreamsScriptFile (val name: String,
                             @SerializedName("package") val packagePath: String,
                             val params: List<DreamsScriptParameter> = emptyList(),
                             val methods: List<DreamsScriptMethod> = emptyList())