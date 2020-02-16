package fr.eline.dreamsapi.nodes

import fr.eline.dreamsapi.DreamsScript
import fr.eline.dreamsapi.addLogDebug
import fr.eline.dreamsapi.addLogError
import java.util.*

// Author: Nourredine OCTEAU
// éline Technologies 2020

class DreamsScriptNodeGet(override val uid: UUID,
                          val param_name: String,
                          override val flags: String) : DreamsScriptNode(uid, DreamsScriptNodeType.Get.typeName, flags){

    constructor(param_name: String, flags: String) : this(UUID.randomUUID(), param_name, flags)

    override fun exec(scriptHost: DreamsScript) : Int {
        addLogDebug("Exec node ${uid} of type ${nodeType.typeName}")
        val paramToGet = scriptHost.scriptParameters.firstOrNull({it.name == param_name})
        if(paramToGet != null) {
            return 0
        } else {
            addLogError("Unable to find script parameter ${param_name}.")
            return -1
        }
    }
}