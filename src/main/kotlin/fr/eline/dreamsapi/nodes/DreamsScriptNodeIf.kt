package fr.eline.dreamsapi.nodes

import com.google.gson.annotations.SerializedName
import java.util.*

// Author: Nourredine OCTEAU
// éline Technologies 2020

class DreamsScriptNodeIf(override val uid: UUID, override val flags: String = "") : DreamsScriptNode(uid, DreamsScriptNodeType.If.typeName, flags){
    constructor(flags: String = "") : this(UUID.randomUUID(), flags)
}