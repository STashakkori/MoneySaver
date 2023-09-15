// CommandQueue.kt
// By: Sina Tashakkori, QVLx Labs

package moneysaver

import java.io.File

class CommandQueue {
  private val commands = mutableListOf<Command>()

  fun addCommand(command: Command) {
    commands.add(command)
  }

  fun executeAll(arguments: Arguments): List<File> {
    val resultFiles = mutableListOf<File>()
    for (command in commands) {
      resultFiles.addAll(command.execute())
    }
    return resultFiles
  }
}