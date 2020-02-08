package fr.eline.dreamsapi.nodes

import java.util.*

// Author: Nourredine OCTEAU
// éline Technologies 2020

class DreamsScriptNodeGet(override val uid: UUID) : DreamsScriptNode(uid, DreamsScriptNodeType.Get){
    constructor() : this(UUID.randomUUID())
}