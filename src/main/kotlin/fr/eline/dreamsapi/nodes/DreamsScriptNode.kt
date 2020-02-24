package fr.eline.dreamsapi.nodes

import com.google.gson.annotations.SerializedName
import fr.eline.dreamsapi.DreamsScript
import fr.eline.dreamsapi.DreamsScriptMethod
import java.util.*
import kotlin.collections.ArrayList

// Author: Nourredine OCTEAU
// éline Technologies 2020

open class DreamsScriptNode (open val uid: UUID,
                             @SerializedName("node_type") private val _nodeType: String,
                             open val flags: String,
                             open val next_nodes: ArrayList<UUID>,
                             open val args_in: ArrayList<UUID>,
                             open val args_out: ArrayList<UUID>) {

    protected var inputs: MutableMap<UUID, Any> = mutableMapOf()

    val nodeType
    get() = DreamsScriptNodeType.valueOf(_nodeType)

    protected val nextNodes: ArrayList<DreamsScriptNode> = ArrayList()

    fun setInput(uid: UUID, value: Any){
        inputs[uid] = value
    }

    fun appendNextNode(nextNode: DreamsScriptNode){
        nextNodes.add(nextNode)
    }

    fun gotoNextNodes(scriptHost: DreamsScript, currentMethod: DreamsScriptMethod) : Int {
        for (node in nextNodes){
            node.exec(scriptHost, currentMethod)
        }
        return 0
    }

    open fun exec(scriptHost: DreamsScript, currentMethod: DreamsScriptMethod) : Int {
        return 0
    }

}