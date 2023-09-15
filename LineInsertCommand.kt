// LineInsertCommand.kt

package moneysaver

import java.io.File

class LineInsertCommand(override val arguments: Arguments) : Command {
  override fun validate(): Boolean {
    return false
  }

  override fun execute(): List<File> {
    return emptyList()
  }
}