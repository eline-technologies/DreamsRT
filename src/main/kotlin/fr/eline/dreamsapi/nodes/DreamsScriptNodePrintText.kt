package fr.eline.dreamsapi.nodes

import com.google.gson.annotations.SerializedName
import fr.eline.dreamsapi.DreamsScript
import java.util.*

// Author: Nourredine OCTEAU
// éline Technologies 2020

class DreamsScriptNodePrintText(override val uid: UUID,
                                override val flags: String) : DreamsScriptNode(uid, DreamsScriptNodeType.Get.typeName, flags){

    constructor(flags: String) : this(UUID.randomUUID(), flags)

}