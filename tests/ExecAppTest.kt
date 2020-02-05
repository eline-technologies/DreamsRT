import fr.eline.dreamsapi.DreamsScriptInterpreter
import fr.eline.dreamsapi.getDreamsScriptOutput
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

// Author: Nourredine OCTEAU
// éline Technologies 2020

internal class ExecAppTest {

    @Test
    fun loadAndExecHelloworldApp(){
        val script = DreamsScriptInterpreter().loadScript("tests_resources/HelloWorldDreamsScript.vApp/Scripts/main.dreamsscript")
        assertNotNull(script)
        script?.exec()
        assertEquals("INFO loading fr.eline.helloworld.Main script...\nDEBUG test\n", getDreamsScriptOutput())
    }

}