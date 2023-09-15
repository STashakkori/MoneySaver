// ConsoleView.kt
// By: Sina Tashakkori, QVLx Labs

package moneysaver

class ConsoleView : View {
    override fun displayMessage(message: String) {
      println(message)
    }

    override fun displayError(error: String) {
      System.err.println("Error: $error")
    }
}