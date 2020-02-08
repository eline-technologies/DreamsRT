import fr.eline.dreamsapi.DreamsScriptLoader
import fr.eline.dreamsapi.clearDreamsScriptOutput
import junit.framework.Assert.assertNull
import junit.framework.Assert.assertNotNull
import org.junit.After
import org.junit.Test

// Author: Nourredine OCTEAU
// éline Technologies 2020

internal class LoadAppTest {

    @Test
    fun loadValidAppTest() {
        val script = DreamsScriptLoader().loadScript("src/test/resources/HelloWorldDreamsScript.vApp/Scripts/main.dreamsscript")
        assertNotNull(script)
    }

    @Test
    fun loadInvalidAppTest() {
        val script = DreamsScriptLoader().loadScript("blahblah.txt")
        assertNull(script)
    }

    @After
    fun clearAllOutputLog() {
        clearDreamsScriptOutput()
    }

}