package fr.eline.dreamsapi

import com.google.gson.annotations.SerializedName
import fr.eline.dreamsapi.nodes.DreamsScriptNode
import fr.eline.dreamsapi.nodes.DreamsScriptNodeFile
import java.util.*
import kotlin.collections.ArrayList

// Author: Nourredine OCTEAU
// éline Technologies 2020

class DreamsScriptMethod(val x: Int,
                         val y: Int,
                         val name: String,
                         @SerializedName("nodes") private val _nodes: List<DreamsScriptNodeFile>,
                         private var _allNodes: ArrayList<DreamsScriptNode>) {

    val allNodes: ArrayList<DreamsScriptNode>
        get() = _allNodes

    fun loadNodes() {
        _allNodes = arrayListOf()
        for(n in _nodes){
            n.getNodeInstance()?.let { _allNodes.add(it) }
        }
        orderNodes(null)
    }

    private fun orderNodes(startNode: DreamsScriptNode?) {
        var nodeToOrder = startNode
        if (nodeToOrder == null) {
            nodeToOrder = allNodes.firstOrNull({ it.flags == "#_method_start" })
        }
        if(nodeToOrder != null) {
            for (nodeUid in nodeToOrder.next_nodes) {
                val nextNode = allNodes.firstOrNull { it.uid == nodeUid }
                if(nextNode != null){
                    nodeToOrder.appendNextNode(nextNode)
                    orderNodes(nextNode)
                }
            }
        }
    }

    fun setInArgNode(arg_uid: UUID, arg_value: Any) {
        var node = allNodes.firstOrNull({it.args_in.contains(arg_uid)})
        if(node != null){
            node.setInput(arg_uid, arg_value)
        }
    }

    fun exec(scriptHost: DreamsScript) : Int {
        val startNode = allNodes.firstOrNull({it.flags == "#_method_start"})
        if(startNode != null){
            return startNode.exec(scriptHost, this)
        } else{
            return -2
        }
    }
}