package fr.eline.dreamsapi.nodes

import com.google.gson.annotations.SerializedName
import java.util.*

// Author: Nourredine OCTEAU
// éline Technologies 2020

class DreamsScriptNodeFile (val uid: UUID,
                            @SerializedName("node_type") private val _nodeType: String,
                            @SerializedName("param_name") val paramName: String,
                            val flags:String = "",
                            val next_nodes: ArrayList<UUID>) {

    val nodeType
    get() = DreamsScriptNodeType.valueOf(_nodeType)

    fun getNodeInstance(): DreamsScriptNode? {
        when (nodeType){
            DreamsScriptNodeType.Get -> return DreamsScriptNodeGet(uid, paramName, flags?:"", next_nodes)
            DreamsScriptNodeType.If -> return DreamsScriptNodeIf(uid, flags?:"", next_nodes)
            DreamsScriptNodeType.PrintText -> return DreamsScriptNodePrintText(uid, flags?:"", next_nodes)
            else -> return null
        }
    }

}