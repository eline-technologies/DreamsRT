package fr.eline.dreamsapi.nodes

import com.google.gson.annotations.SerializedName
import java.util.*

// Author: Nourredine OCTEAU
// éline Technologies 2020

class DreamsScriptNodeFile (val uid: UUID,
                            @SerializedName("node_type") private val _nodeType: String,
                            @SerializedName("param_name") val paramName: String) {

    val nodeType
    get() = DreamsScriptNodeType.valueOf(_nodeType)

    fun GetNodeInstance(): DreamsScriptNode? {
        when (nodeType){
            DreamsScriptNodeType.Get -> return DreamsScriptNodeGet(uid, paramName)
            DreamsScriptNodeType.If -> return null
            DreamsScriptNodeType.PrintText -> return null
            else -> return null
        }
    }

}