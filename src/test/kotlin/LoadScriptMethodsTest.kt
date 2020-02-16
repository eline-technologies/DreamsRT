import fr.eline.dreamsapi.DreamsScriptLoader
import fr.eline.dreamsapi.clearDreamsScriptOutput
import junit.framework.Assert
import org.junit.After
import org.junit.Test

// Author: Nourredine OCTEAU
// éline Technologies 2020

internal class LoadScriptMethodsTest {

    @Test
    fun loadMethodsTest() {
        val script = DreamsScriptLoader().loadScript("src/test/resources/HelloWorldDreamsScript.vApp/Scripts/main.dreamsscript")
        Assert.assertNotNull(script)
        Assert.assertNotNull(script?.scriptMethods)
        Assert.assertEquals(1, script?.scriptMethods?.count())
    }

    @Test
    fun loadMethodNodesTest() {
        val script = DreamsScriptLoader().loadScript("src/test/resources/HelloWorldDreamsScript.vApp/Scripts/main.dreamsscript")
        Assert.assertNotNull(script)
        Assert.assertNotNull(script?.scriptMethods)
        Assert.assertEquals(1, script?.scriptMethods?.count())
        Assert.assertNotNull(script?.scriptMethods?.first()?.allNodes)
        Assert.assertEquals(4, script?.scriptMethods?.first()?.allNodes?.count())
    }

    @After
    fun clearAllOutputLog() {
        clearDreamsScriptOutput()
    }

}