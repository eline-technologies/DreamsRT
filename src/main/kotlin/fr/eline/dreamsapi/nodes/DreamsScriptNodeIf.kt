package fr.eline.dreamsapi.nodes

import com.google.gson.annotations.SerializedName
import fr.eline.dreamsapi.DreamsScript
import fr.eline.dreamsapi.DreamsScriptMethod
import fr.eline.dreamsapi.addLogDebug
import fr.eline.dreamsapi.addLogError
import java.util.*

// Author: Nourredine OCTEAU
// éline Technologies 2020

class DreamsScriptNodeIf(override val x: Int,
                         override val y: Int,
                         override val uid: UUID,
                         override val flags: String = "",
                         override val next_nodes: ArrayList<UUID>,
                         override val args_in: ArrayList<UUID>,
                         override val args_out: ArrayList<UUID>) : DreamsScriptNode(x, y, uid, DreamsScriptNodeType.If.typeName, flags, next_nodes, args_in, args_out){

    constructor(x: Int, y: Int, flags: String, next_nodes: ArrayList<UUID>, args_in: ArrayList<UUID>, args_out: ArrayList<UUID>) : this(x, y, UUID.randomUUID(), flags, next_nodes, args_in, args_out)

    override fun exec(scriptHost: DreamsScript, currentMethod: DreamsScriptMethod) : Int {
        addLogDebug("Exec node ${uid} of type ${nodeType.typeName}")
        val condition: Boolean = this.inputs[args_in[0]] as Boolean
        if(condition){
            addLogDebug("Go to next True node")
            nextNodes[0].exec(scriptHost, currentMethod)
        }
        else{
            addLogDebug("Go to next False node")
            nextNodes[1].exec(scriptHost, currentMethod)
        }

        return 0
    }
}