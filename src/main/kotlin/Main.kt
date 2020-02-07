import fr.eline.dreamsapi.DreamsScriptInterpreter

// Author: Nourredine OCTEAU
// éline Technologies 2020

const val version = "0.1.0"

fun main(args: Array<String>) {
    println("Dreams Runtime v$version")
    println("Developed by éline Technologies (https://eline-technologies.fr/)")
    println()

    when {
        args.count() == 0 -> println("Error: A vApp file must be specified in command argument")
        else -> DreamsScriptInterpreter().loadScript("${args.first()}/Scripts/main.dreamsscript")?.exec()
    }
}