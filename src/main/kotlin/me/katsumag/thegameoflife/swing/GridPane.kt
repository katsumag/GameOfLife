package me.katsumag.thegameoflife.swing

import java.awt.Dimension
import java.awt.Graphics
import javax.swing.JPanel

class GridPane(private val rows: Int, private val cols: Int) : JPanel() {

    override fun getPreferredSize() = Dimension(cols * 10, rows * 10)

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)

        val rowHeight = height / rows
        for (i in 0 until rows) {
            g.drawLine(0, i * rowHeight, width, i * rowHeight)
        }

        val rowWidth = width / cols
        for (i in 0 until cols) {
            g.drawLine(i * rowWidth, 0, i * rowWidth, height)
        }

    }

}