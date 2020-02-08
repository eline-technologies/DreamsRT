import fr.eline.dreamsapi.DreamsScriptLoader
import fr.eline.dreamsapi.addLogError

// Author: Nourredine OCTEAU
// éline Technologies 2020

const val version = "0.1.0"

fun main(args: Array<String>) {
    println("Dreams Runtime v$version")
    println("Developed by éline Technologies (https://eline-technologies.fr/)")
    println()

    when {
        args.count() == 0 -> addLogError("A vApp file must be specified in command argument")
        else -> DreamsScriptLoader().loadScript("${args.first()}/Scripts/main.dreamsscript")?.exec()
    }
}