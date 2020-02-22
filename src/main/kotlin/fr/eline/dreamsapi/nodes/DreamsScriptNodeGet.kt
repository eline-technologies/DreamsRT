package fr.eline.dreamsapi.nodes

import fr.eline.dreamsapi.DreamsScript
import fr.eline.dreamsapi.addLogDebug
import fr.eline.dreamsapi.addLogError
import java.util.*
import kotlin.collections.ArrayList

// Author: Nourredine OCTEAU
// éline Technologies 2020

class DreamsScriptNodeGet(override val uid: UUID,
                          val param_name: String,
                          override val flags: String,
                          override val next_nodes: ArrayList<UUID>) : DreamsScriptNode(uid, DreamsScriptNodeType.Get.typeName, flags, next_nodes){

    constructor(param_name: String, flags: String, next_nodes: ArrayList<UUID>) : this(UUID.randomUUID(), param_name, flags, next_nodes)

    override fun exec(scriptHost: DreamsScript) : Int {
        addLogDebug("Exec node ${uid} of type ${nodeType.typeName}")
        val paramToGet = scriptHost.scriptParameters.firstOrNull({it.name == param_name})
        if(paramToGet != null) {
            return gotoNextNodes(scriptHost)
        } else {
            addLogError("Unable to find script parameter ${param_name}.")
            return -1
        }
    }
}