package fr.eline.dreamsapi.nodes

import com.google.gson.annotations.SerializedName
import java.util.*

// Author: Nourredine OCTEAU
// éline Technologies 2020

class DreamsScriptNodeFile (val uid: UUID,
                            @SerializedName("node_type") private val _nodeType: String,
                            @SerializedName("param_name") val paramName: String,
                            val flags:String = "",
                            val next_nodes: ArrayList<UUID>,
                            val args_in: ArrayList<UUID>,
                            val args_out: ArrayList<UUID>) {

    val nodeType
    get() = DreamsScriptNodeType.valueOf(_nodeType)

    fun getNodeInstance(): DreamsScriptNode? {
        when (nodeType){
            DreamsScriptNodeType.Get -> return DreamsScriptNodeGet(uid, paramName, flags?:"", next_nodes, args_in, args_out)
            DreamsScriptNodeType.If -> return DreamsScriptNodeIf(uid, flags?:"", next_nodes, args_in, args_out)
            DreamsScriptNodeType.PrintText -> return DreamsScriptNodePrintText(uid, flags?:"", next_nodes, args_in, args_out)
            else -> return null
        }
    }

}