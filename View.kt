

package moneysaver

interface View {
    fun displayMessage(message: String)
    fun displayError(error: String)
    // Implement more view methods as needed
}

/*
import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.SwingUtilities

fun main() {
    SwingUtilities.invokeLater {
        createAndShowGUI()
    }
}

private fun createAndShowGUI() {
    val frame = JFrame("Kotlin Swing GUI")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.extendedState = JFrame.MAXIMIZED_BOTH  // Set to full-screen

    val mainPanel = JPanel()
    mainPanel.layout = BorderLayout()

    val label = JButton("Hello, Kotlin Swing!")
    label.preferredSize = Dimension(400, 100) // Set preferred button size
    mainPanel.add(label, BorderLayout.CENTER)

    val buttonPanel = JPanel()
    val button1 = JButton("Button 1")
    val button2 = JButton("Button 2")

    buttonPanel.add(button1)
    buttonPanel.add(button2)

    mainPanel.add(buttonPanel, BorderLayout.SOUTH)

    frame.contentPane.add(mainPanel)
    //frame.pack()
    frame.isVisible = true
}
*/