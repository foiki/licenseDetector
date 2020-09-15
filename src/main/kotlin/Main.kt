import java.io.File

private val licensesHeadersParts = mapOf(
    Pair(ApachePart, "Apache-2.0"),
    Pair(MITPart, "MIT"),
    Pair(GPL3Part, "GPL-3.0"),
    Pair(BSD3ClausePart, "BSD-3-Clause"),
    Pair(LGPL3Part, "LGPL-3.0"))

private val projectLicenses = ArrayList<String>()
private var mainLicenseExist = false

fun checkLicenses(directory: File) {
    if (directory.length() == 0L) {
        println("There are no files in this directory!")
    }
    directory.walkTopDown().forEach { file ->
        if (file.isFile && !file.isHidden && file.canRead()) {
            val fileText = file.readText().replace(Regex("\\s"), "")
            licensesHeadersParts.forEach {
                if (fileText.contains(it.key.replace(Regex("\\s"), ""))) {
                    if (!mainLicenseExist && file.parentFile == directory) {
                        mainLicenseExist = true
                    }
                    projectLicenses.add(it.value)
                }
            }
        }
    }
}

fun main() {
    print("Enter project directory: ")
    checkLicenses(File(readLine()!!))
    val licenses = projectLicenses.distinct()
    if (mainLicenseExist) {
        println("Main license of a project: " + licenses.first())
    } else {
        println("Main license not found!")
    }
    if (licenses.size > 1) {
        val otherLicenses = licenses.subList(1, licenses.size)
        println("Other licenses of a project: ")
        otherLicenses.forEach {
            println(it)
        }
    } else {
        println("No other licenses found!")
    }
}
