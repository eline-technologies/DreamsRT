import fr.eline.dreamsapi.DreamsScriptLoader
import fr.eline.dreamsapi.addLogError
import fr.eline.dreamsapi.addLogInfo

// Author: Nourredine OCTEAU
// éline Technologies 2020

const val version = "0.1.0"

fun main(args: Array<String>) {
    println("Dreams Runtime v$version")
    println("Developed by éline Technologies (https://eline-technologies.fr/)")
    println()

    when {
        args.count() == 0 -> addLogError("A vApp file must be specified in command argument")
        else -> {
            val script = DreamsScriptLoader().loadScript("${args.first()}/Scripts/main.dreamsscript")
            if(script == null)
            {
                addLogError("Unable to parse script. File content is invalid.")
                return
            }
            else {
                val retCode = script.exec()
                when (retCode) {
                    0 -> addLogInfo("Script successfully executed.")
                    else -> addLogError("Script executed with error ${retCode}.")
                }
            }
        }
    }
}