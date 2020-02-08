package fr.eline.dreamsapi.nodes

import com.google.gson.annotations.SerializedName
import java.util.*

// Author: Nourredine OCTEAU
// éline Technologies 2020

open class DreamsScriptNode (open val uid: UUID, @SerializedName("node_type") private val _nodeType: String) {
    val nodeType
    get() = DreamsScriptNodeType.valueOf(_nodeType)
}