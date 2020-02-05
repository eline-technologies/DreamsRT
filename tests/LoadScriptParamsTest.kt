import fr.eline.dreamsapi.DreamsScriptInterpreter
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

// Author: Nourredine OCTEAU
// éline Technologies 2020

internal class LoadScriptParamsTest {

    @Test
    fun loadParamsTest() {
        val script = DreamsScriptInterpreter().loadScript("tests_resources/HelloWorldDreamsScript.vApp/Scripts/main.dreamsscript")
        assertNotNull(script)
        assertNotNull(script?.scriptParameters)
        assertEquals(1, script?.scriptParameters?.count())
    }

}