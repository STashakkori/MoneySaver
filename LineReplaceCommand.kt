// LineReplaceCommand.kt
// By: Sina Tashakkori, QVLx Labs

package moneysaver

import java.io.File

class LineReplaceCommand(override val arguments: Arguments) : Command {
  override fun validate(): Boolean {
    return false
  }

  override fun execute(): List<File> {
    return emptyList()
  }
}