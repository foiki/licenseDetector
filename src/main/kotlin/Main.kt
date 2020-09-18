import java.io.File

private val projectLicenses = ArrayList<String>()
private var mainLicenseExist = false

fun getFileHeader(file: File): String {
    return file.bufferedReader().useLines {
        lines -> lines.take(30).joinToString(separator = "")
    }
}

fun readFile(file: File): String {
    return if (textFileExtensions.contains(file.extension.toLowerCase())) {
        file.readText()
    } else {
        getFileHeader(file)
    }.replace(Regex("\\s"), "")
}

fun checkLicenses(directory: File) {
    if (directory.length() == 0L) {
        println("There are no files in this directory!")
    }
    directory.walkTopDown().forEach { file ->
        if (file.isFile && !file.isHidden && file.canRead()) {
            val fileText = readFile(file)
            licensesHeadersParts.forEach {
                if (fileText.contains(it.key)) {
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
