// MoneySaver
// By: Sina Tashakkori, QVLx Labs

import java.io.File

fun main(args: Array<String>) {
    if (args.size != 5) {
        println("Usage: kotlin InsertText.kt <directory> <file_extensions> <line_number> <text_to_insert> <size_threshold>")
        return
    }

    val directory = File(args[0])
    val extensions = args[1].split(".")
    val lineNumber = args[2].toInt()
    val sizeThreshold = args[3].toLong()
    val textToInsert = args[4]

    if (!directory.exists() || !directory.isDirectory) {
        println("Error: The specified directory does not exist or is not a directory.")
        return
    }

    try {
        val (insertedFiles, totalSize) = processFiles(directory, extensions, lineNumber, textToInsert, sizeThreshold)

        println("Inserted text into ${insertedFiles.size} files:")
        insertedFiles.forEach { println(it.absolutePath) }
        println("Total size of processed files: ${totalSize / (1024 * 1024)} MB")
    } catch (e: Exception) {
        println("An error occurred: ${e.message}")
    }
}

fun processFiles(
    directory: File,
    extensions: List<String>,
    lineNumber: Int,
    textToInsert: String,
    sizeThreshold: Long
): Pair<MutableList<File>, Long> {
    val insertedFiles = mutableListOf<File>()
    var totalSize = 0L

    directory.walk().forEach {
        if (it.isFile && extensions.any { ext -> it.name.endsWith(ext) }) {
            val fileSize = it.length()

            if (totalSize + fileSize <= sizeThreshold) {
                val lines = it.readLines().toMutableList()

                if (lineNumber >= 0 && lineNumber <= lines.size) {
                    lines.add(lineNumber, textToInsert)
                    it.writeText(lines.joinToString("\n"))
                    insertedFiles.add(it)
                    totalSize += fileSize
                }
            }
        }
    }

    return Pair(insertedFiles, totalSize)
}
