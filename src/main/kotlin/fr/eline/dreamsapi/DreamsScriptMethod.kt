package fr.eline.dreamsapi

import com.google.gson.annotations.SerializedName
import fr.eline.dreamsapi.nodes.DreamsScriptNode
import fr.eline.dreamsapi.nodes.DreamsScriptNodeFile

// Author: Nourredine OCTEAU
// éline Technologies 2020

class DreamsScriptMethod(val name: String,
                         @SerializedName("nodes") private val _nodes: List<DreamsScriptNodeFile>,
                         private var _allNodes: ArrayList<DreamsScriptNode>) {

    val allNodes: ArrayList<DreamsScriptNode>
        get() = _allNodes

    fun loadNodes() {
        _allNodes = arrayListOf()
        for(n in _nodes){
            n.GetNodeInstance()?.let { _allNodes.add(it) }
        }
    }

    fun exec() : Int {
        return 0;
    }
}