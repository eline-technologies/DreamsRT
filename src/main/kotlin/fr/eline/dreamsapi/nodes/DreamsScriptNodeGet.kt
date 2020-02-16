package fr.eline.dreamsapi.nodes

import com.google.gson.annotations.SerializedName
import java.util.*

// Author: Nourredine OCTEAU
// éline Technologies 2020

class DreamsScriptNodeGet(override val uid: UUID, val param_name: String, override val flags: String) : DreamsScriptNode(uid, DreamsScriptNodeType.Get.typeName, flags){
    constructor(param_name: String, flags: String = "") : this(UUID.randomUUID(), param_name, flags)
}