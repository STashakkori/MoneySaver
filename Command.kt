// Command.kt
// By: Sina Tashakkori, QVLx Labs

package moneysaver

import java.io.File

data class Arguments(
  val pathType: PathType, // Non-arg. Gets set for internal use
  val sourcePath: File, // Path to perform command on. A file or folder
  val command: CommandType, // Command to perform on file or folder
  val maxSize: Long, // Max number of bytes that can be performed on.
  val extension: String, // File extension to perform on. Optional
  val lineNumber: Int, // Line number in files to perform on. Optional
  val textToInsert: String, // Insertion payload. Optional for command
  val textToFind: String // String to find. Optional for command.
)

enum class PathType {
  SINGLE,
  DIRECTORY,
  UNKNOWN
}

enum class CommandType {
  END,
  QUIT,
  READ_SCRIPT,
  FIND_INSERT,
  FIND_REPLACE,
  LINE_INSERT,
  LINE_REPLACE,
  UNKNOWN
}

interface Command {
  val arguments: Arguments

  fun validate(): Boolean
  fun execute(): List<File>

  fun checkTotalSize(directory: File, extension: List<String>, maxSize: Long): Long {
    var totalSize = 0L

    directory.walk().forEach {
      if (it.isFile && extension.any { ext -> it.name.endsWith(ext) }) {
        val fileSize = it.length()
        totalSize += fileSize
      }
    }

    return if (totalSize <= maxSize) totalSize else -1L
  }
}