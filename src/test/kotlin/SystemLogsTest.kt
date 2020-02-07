import fr.eline.dreamsapi.*
import junit.framework.Assert.assertEquals
import org.junit.Test

// Author: Nourredine OCTEAU
// éline Technologies 2020

internal class SystemLogsTest {

    @Test
    fun addDebugLogTest(){
        val debugLine = "add a debug log line"
        val expectedLogLine = "DEBUG ${debugLine}\n"
        addLogDebug(debugLine)
        assertEquals(expectedLogLine, getDreamsScriptOutput())
        clearDreamsScriptOutput()
    }

    @Test
    fun addInfoLogTest(){
        val infoLine = "add an info log line"
        val expectedLogLine = "INFO ${infoLine}\n"
        addLogInfo(infoLine)
        assertEquals(expectedLogLine, getDreamsScriptOutput())
        clearDreamsScriptOutput()
    }

    @Test
    fun addWarningLogTest(){
        val warningLine = "add an warning log line"
        val expectedLogLine = "WARNING ${warningLine}\n"
        addLogWarning(warningLine)
        assertEquals(expectedLogLine, getDreamsScriptOutput())
        clearDreamsScriptOutput()
    }

    @Test
    fun addErrorLogTest(){
        val errorLine = "add an error log line"
        val expectedLogLine = "ERROR ${errorLine}\n"
        addLogError(errorLine)
        assertEquals(expectedLogLine, getDreamsScriptOutput())
        clearDreamsScriptOutput()
    }

    @Test
    fun clearLogTest(){
        val debugLine = "add a debug log line"
        val expectedLogLine = "DEBUG ${debugLine}\n"
        addLogDebug(debugLine)
        clearDreamsScriptOutput()
        assertEquals("", getDreamsScriptOutput())
    }

}