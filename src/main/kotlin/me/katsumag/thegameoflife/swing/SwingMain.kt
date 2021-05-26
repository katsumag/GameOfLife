package me.katsumag.thegameoflife.swing

import me.katsumag.thegameoflife.transform
import javax.swing.JFrame
import javax.swing.SwingUtilities

//TODO attach run button along bottom, select starting sequence, actual game

fun main() {
    SwingUtilities.invokeLater {
        JFrame("Grid").transform {
            add(GridPane(10,10))
            pack()
            isVisible = true
            defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        }
    }
}