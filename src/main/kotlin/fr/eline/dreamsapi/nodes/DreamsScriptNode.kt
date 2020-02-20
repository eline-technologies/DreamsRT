package fr.eline.dreamsapi.nodes

import com.google.gson.annotations.SerializedName
import fr.eline.dreamsapi.DreamsScript
import java.util.*

// Author: Nourredine OCTEAU
// éline Technologies 2020

open class DreamsScriptNode (open val uid: UUID,
                             @SerializedName("node_type") private val _nodeType: String,
                             open val flags: String,
                             open val next_nodes: ArrayList<UUID>) {

    val nodeType
    get() = DreamsScriptNodeType.valueOf(_nodeType)

    open fun exec(scriptHost: DreamsScript) : Int {
        return 0
    }

}