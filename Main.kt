//import java.io.File
//import java.time.LocalDateTime
//import java.time.format.DateTimeFormatter

package moneysaver

fun main(args: Array<String>) {
  val cmdFactory = CommandFactory()
  val command = cmdFactory.createCommand(args)
  val valid = command.validate()
  if (!valid) { return }
  command.execute()
}

/*
fun processFiles(directory: File,
                 extension: List<String>,
                 lineNumber: Int,
                 textToInsert: String): Pair<MutableList<File>, Long> {
  val insertedFiles = mutableListOf<File>()
  var totalSize = 0L

  val backupFolder = File(directory, "backup")
  backupFolder.mkdirs()

  directory.walk().forEach {
    if (it.isFile && extension.any { ext -> it.name.endsWith(ext) }) {
      val fileSize = it.length()

      // Backup each file before it's processed
      val backupFile = File(backupFolder, "${it.nameWithoutExtension}_${timestamp()}.${it.extension}")
      it.copyTo(backupFile)

      val lines = it.readLines().toMutableList()

      if (lineNumber >= 0 && lineNumber <= lines.size) {
        lines.add(lineNumber, textToInsert)
        it.writeText(lines.joinToString("\n"))
        insertedFiles.add(it)
      }
    }
  }

  return insertedFiles
}

fun timestamp(): String {
  val formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")
  return LocalDateTime.now().format(formatter)
}

*/