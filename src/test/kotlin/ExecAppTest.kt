import fr.eline.dreamsapi.DreamsScriptInterpreter
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Test

// Author: Nourredine OCTEAU
// éline Technologies 2020

internal class ExecAppTest {

    @Test
    fun loadAndExecHelloworldApp(){
        val script = DreamsScriptInterpreter().loadScript("src/test/resources/HelloWorldDreamsScript.vApp/Scripts/main.dreamsscript")
        assertNotNull(script)
        assertEquals(0, script?.exec())
    }

}