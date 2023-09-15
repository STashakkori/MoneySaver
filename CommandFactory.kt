// CommandFactory.kt
// By: Sina Tashakkori, QVLx Labs

package moneysaver

import java.io.File

class CommandFactory {
  fun determineCommandType(input: String): CommandType {
    return when (input) {
      "end" -> CommandType.END
      "quit" -> CommandType.QUIT
      "read_script" -> CommandType.READ_SCRIPT
      "find_insert" -> CommandType.FIND_INSERT
      "find_replace" -> CommandType.FIND_REPLACE
      "line_insert" -> CommandType.LINE_INSERT
      "line_replace" -> CommandType.LINE_REPLACE
      else -> CommandType.UNKNOWN
    }
  }

  fun preprocessArgs(cmd: CommandType, args: Array<String>): Arguments {
    val sourcePath = File(args[0])
    val command = cmd
    val maxSize = args.getOrNull(2)?.toLongOrNull() ?: 104857600
    val extension = args.getOrNull(3) ?: ""
    val lineNumber = args.getOrNull(4)?.toIntOrNull() ?: -1
    val textToInsert = args.getOrNull(5) ?: ""
    val textToFind = args.getOrNull(6) ?: ""
    val pathType = if (sourcePath.exists()) {
      if (sourcePath.isDirectory) PathType.DIRECTORY
      else PathType.SINGLE
    }
    else {
      ErrorManager.pushError(SeverityLevel.LOW, "Invalid path type given.")
      PathType.UNKNOWN
    }

    return Arguments(pathType, sourcePath, command, maxSize,
                     extension, lineNumber, textToInsert, textToFind)
  }

  fun createCommand(rawArgs: Array<String>): Command {
    val commandType = determineCommandType(rawArgs[1])
    val arguments = preprocessArgs(commandType, rawArgs)

    return when (commandType) {
      CommandType.END -> EndCommand(arguments)
      CommandType.QUIT -> QuitCommand(arguments)
      CommandType.READ_SCRIPT -> ReadScriptCommand(arguments)
      CommandType.FIND_INSERT -> FindInsertCommand(arguments)
      CommandType.FIND_REPLACE -> FindReplaceCommand(arguments)
      CommandType.LINE_INSERT -> LineInsertCommand(arguments)
      CommandType.LINE_REPLACE -> LineReplaceCommand(arguments)
      CommandType.UNKNOWN -> { 
        ErrorManager.pushError(SeverityLevel.LOW, "Unknown command given.")
        EndCommand(arguments)
      }
    }
  }

  fun extractExtension(extensionArg: String): String {
    return extensionArg.substringAfterLast(".", "")
  }
}