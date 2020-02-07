import fr.eline.dreamsapi.DreamsScriptInterpreter
import fr.eline.dreamsapi.clearDreamsScriptOutput
import junit.framework.Assert.assertNull
import junit.framework.Assert.assertNotNull
import org.junit.After
import org.junit.BeforeClass
import org.junit.Test

// Author: Nourredine OCTEAU
// éline Technologies 2020

internal class LoadAppTest {

    @Test
    fun loadValidAppTest() {
        val script = DreamsScriptInterpreter().loadScript("src/test/resources/HelloWorldDreamsScript.vApp/Scripts/main.dreamsscript")
        assertNotNull(script)
    }

    @Test
    fun loadInvalidAppTest() {
        val script = DreamsScriptInterpreter().loadScript("blahblah.txt")
        assertNull(script)
    }

    @After
    fun clearAllOutputLog() {
        clearDreamsScriptOutput()
    }

}