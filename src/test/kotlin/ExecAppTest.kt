import fr.eline.dreamsapi.clearDreamsScriptOutput
import fr.eline.dreamsapi.getDreamsScriptOutput
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

    @Test
    fun loadAndExecInvalidScriptAppArgs(){
        val args: Array<String> = Array(1) { "src/test/resources/HelloWorldDreamsInvalidScript.vApp" }
        main(args)
        assertTrue(getDreamsScriptOutput().contains("ERROR Unable to parse script. File content is invalid."))
    }

    @Test
    fun loadAndExecScriptWithoutInitMethodAppArgs(){
        val args: Array<String> = Array(1) { "src/test/resources/HelloWorldDreamsScriptWithoutInitMethod.vApp" }
        main(args)
        assertTrue(getDreamsScriptOutput().contains("ERROR Script executed with error -1."))
    }

    @After
    fun clearAllOutputLog() {
        clearDreamsScriptOutput()
    }

}