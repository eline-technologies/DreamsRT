package fr.eline.dreamsapi.nodes

import com.google.gson.annotations.SerializedName
import fr.eline.dreamsapi.DreamsScript
import java.util.*
import kotlin.collections.ArrayList

// Author: Nourredine OCTEAU
// éline Technologies 2020

open class DreamsScriptNode (open val uid: UUID,
                             @SerializedName("node_type") private val _nodeType: String,
                             open val flags: String,
                             open val next_nodes: ArrayList<UUID>) {

    val nodeType
    get() = DreamsScriptNodeType.valueOf(_nodeType)

    private val nextNodes: ArrayList<DreamsScriptNode> = ArrayList()

    fun appendNextNode(nextNode: DreamsScriptNode){
        nextNodes.add(nextNode)
    }

    fun gotoNextNodes(scriptHost: DreamsScript) : Int {
        for (node in nextNodes){
            node.exec(scriptHost)
        }
        return 0
    }

    open fun exec(scriptHost: DreamsScript) : Int {
        return 0
    }

}