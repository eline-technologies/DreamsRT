import fr.eline.dreamsapi.DreamsScriptInterpreter
import fr.eline.dreamsapi.clearDreamsScriptOutput
import fr.eline.dreamsapi.getDreamsScriptOutput
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Test

// Author: Nourredine OCTEAU
// éline Technologies 2020

internal class ExecAppTest {

    @Test
    fun loadAndExecHelloworldApp(){
        val args: Array<String> = Array(1) { "src/test/resources/HelloWorldDreamsScript.vApp" }
        main(args)
        assertTrue(getDreamsScriptOutput().contains("DEBUG Loaded script parameter: private bool is_ok = true"))
    }

    @Test
    fun loadAndExecNoAppArgs(){
        val args: Array<String> = emptyArray()
        main(args)
        assertTrue(getDreamsScriptOutput().contains("ERROR A vApp file must be specified in command argument"))
    }

    @After
    fun clearAllOutputLog() {
        clearDreamsScriptOutput()
    }

}