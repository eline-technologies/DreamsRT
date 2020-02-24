package fr.eline.dreamsapi.nodes

import com.google.gson.annotations.SerializedName
import fr.eline.dreamsapi.DreamsScript
import fr.eline.dreamsapi.DreamsScriptMethod
import fr.eline.dreamsapi.addLogDebug
import fr.eline.dreamsapi.addLogInfo
import java.util.*

// Author: Nourredine OCTEAU
// éline Technologies 2020

class DreamsScriptNodePrintText(override val uid: UUID,
                                override val flags: String,
                                override val next_nodes: ArrayList<UUID>,
                                override val args_in: ArrayList<UUID>,
                                override val args_out: ArrayList<UUID>) : DreamsScriptNode(uid, DreamsScriptNodeType.PrintText.typeName, flags, next_nodes, args_in, args_out){

    constructor(flags: String, next_nodes: ArrayList<UUID>, args_in: ArrayList<UUID>, args_out: ArrayList<UUID>) : this(UUID.randomUUID(), flags, next_nodes, args_in, args_out)

    override fun exec(scriptHost: DreamsScript, currentMethod: DreamsScriptMethod) : Int {
        addLogDebug("Exec node ${uid} of type ${nodeType.typeName}")
        val text: String = this.inputs[args_in[0]] as String
        addLogInfo(text)
        return 0
    }
}