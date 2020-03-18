package fr.eline.dreamsapi.nodes

import fr.eline.dreamsapi.DreamsScript
import fr.eline.dreamsapi.DreamsScriptMethod
import fr.eline.dreamsapi.addLogDebug
import fr.eline.dreamsapi.addLogError
import java.util.*
import kotlin.collections.ArrayList

// Author: Nourredine OCTEAU
// éline Technologies 2020

class DreamsScriptNodeGet(override val x: Int,
                          override val y: Int,
                          override val uid: UUID,
                          val param_name: String,
                          override val flags: String,
                          override val next_nodes: ArrayList<UUID>,
                          override val args_in: ArrayList<UUID>,
                          override val args_out: ArrayList<UUID>) : DreamsScriptNode(x, y, uid, DreamsScriptNodeType.Get.typeName, flags, next_nodes, args_in, args_out){

    constructor(x: Int, y: Int, param_name: String, flags: String, next_nodes: ArrayList<UUID>, args_in: ArrayList<UUID>, args_out: ArrayList<UUID>) : this(x, y, UUID.randomUUID(), param_name, flags, next_nodes, args_in, args_out)

    override fun exec(scriptHost: DreamsScript, currentMethod: DreamsScriptMethod) : Int {
        addLogDebug("Exec node ${uid} of type ${nodeType.typeName}")
        val paramToGet = scriptHost.scriptParameters.firstOrNull({it.name == param_name})
        if(paramToGet != null) {
            currentMethod.setInArgNode(args_out[0], paramToGet.value)
            return gotoNextNodes(scriptHost, currentMethod)
        } else {
            addLogError("Unable to find script parameter ${param_name}.")
            return -1
        }
    }
}