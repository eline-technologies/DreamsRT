package fr.eline.dreamsapi.nodes

import com.google.gson.annotations.SerializedName
import fr.eline.dreamsapi.DreamsScript
import fr.eline.dreamsapi.addLogDebug
import fr.eline.dreamsapi.addLogError
import java.util.*

// Author: Nourredine OCTEAU
// éline Technologies 2020

class DreamsScriptNodeIf(override val uid: UUID,
                         override val flags: String = "",
                         override val next_nodes: ArrayList<UUID>) : DreamsScriptNode(uid, DreamsScriptNodeType.If.typeName, flags, next_nodes){

    constructor(flags: String, next_nodes: ArrayList<UUID>) : this(UUID.randomUUID(), flags, next_nodes)

    override fun exec(scriptHost: DreamsScript) : Int {
        addLogDebug("Exec node ${uid} of type ${nodeType.typeName}")
        return 0
    }
}