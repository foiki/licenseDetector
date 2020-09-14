import java.io.File

private val supportedLicenses = listOf("license", "apache", "mit", "gpl3", "bsd3", "lgpl")
private val licensesExtensions = listOf("", "txt", "md")

private val projectLicenses = ArrayList<String>()
private var mainLicenseExist = false

fun getLicense(directory: File) {
    val licenseTest = directory.readText()
    licenseTest.split(" ").forEach {
        when(it.toUpperCase()) {
            "APACHE" -> projectLicenses.add("Apache-2.0")
            "MIT" -> projectLicenses.add(it)
            "GNU" -> projectLicenses.add("GPL-3.0")
        }
    }
}

fun checkLicenses(directory: File) {
    if (directory.length() == 0L) {
        println("There are no files in this directory!")
    }
    var counter = 0
    directory.walkTopDown().forEach {
        val name = it.nameWithoutExtension
        if (it.isFile
            && supportedLicenses.contains(name.toLowerCase())
            && licensesExtensions.contains(it.extension.toLowerCase())) {
            if (!mainLicenseExist && it.parentFile == directory) {
                mainLicenseExist = true
            }
            getLicense(it)
            ++counter
        }
    }
    if (counter == 0) {
        println("The most popular licenses were not found in the project!")
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
    val otherLicenses = licenses.subList(1, licenses.size)
    if (otherLicenses.isNotEmpty()) {
        println("Other licenses of a project: ")
        otherLicenses.forEach {
            println(it)
        }
    } else {
        println("No other licenses found!")
    }
}
