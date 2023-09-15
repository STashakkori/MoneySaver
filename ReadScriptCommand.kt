// ReadScriptCommand.kt
// By: Sina Tashakkori, QVLx Labs

package moneysaver

import java.io.File

class ReadScriptCommand(override val arguments: Arguments) : Command {
  override fun validate(): Boolean {
    return true
  }

  override fun execute(): List<File> {
    return emptyList()
  }
}