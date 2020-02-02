import fr.eline.dreamsapi.DreamsScriptInterpreter
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Asserter

// Author: Nourredine OCTEAU
// éline Technologies 2020

internal class LoadAppTest {

    @Test
    fun loadValidAppTest() {
        val script = DreamsScriptInterpreter().loadScript("tests_resources/HelloWorldDreamsScript.vApp/Scripts/main.dreamsscript")
        assertNotNull(script)
    }

    @Test
    fun loadInvalidAppTest() {
        val script = DreamsScriptInterpreter().loadScript("blahblah.txt")
        assertNull(script)
    }

}