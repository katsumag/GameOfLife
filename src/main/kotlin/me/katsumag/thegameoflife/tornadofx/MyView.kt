package me.katsumag.thegameoflife.tornadofx

import javafx.scene.control.Button
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import javafx.scene.text.Font
import me.katsumag.thegameoflife.game.*
import tornadofx.*

class MasterView : View() {

    override val root = borderpane {
        top<Header>()
        center<Game>()
        bottom<Footer>()
    }

}

class Header : View() {
    override val root = textflow {
        text("Conway's Game Of Life") {
            fill = Color.PURPLE
            font = Font(20.0)
        }
    }
}

class Footer : View() {

    override val root = hbox {
        togglebutton("Start") {
            action {
                EntryPoint().populate(wrappedCellStorage)
            }
            /*
            action {
                text = if (isSelected) "Stop" else "Start"
            }
             */
            val stateText = selectedProperty().stringBinding {
                if (isSelected) "Stop" else "Start"
            }
            textProperty().bind(stateText)
        }
    }

}

class Game : View() {
    override val root = gridpane {
        println("width $width height $height")
        for (y in 1..5) {
            row {
                for (x in 1..5) {
                    val position = Position(x, y)
                    val gameButton = getNewButton(position)
                    add(gameButton)
                    wrappedCellStorage.add(WrappedCell(Cell(false, position), gameButton))
                }
            }

        }

    }
}

fun getNewButton(position: Position) = Button("${position.x}, ${position.y}").apply {
    useMaxWidth = true
    gridpaneConstraints {
        marginBottom = 0.0
        columnSpan = 1
    }
    action {
        println(wrappedCellStorage)
        style {
            val wrappedCell = wrappedCellStorage.find { it.button.text == this@apply.text }!!
            val oldWrappedCell = wrappedCell
            wrappedCell.cell.apply { state = !state }
            backgroundColor = if (wrappedCell.cell.state) {
                Color.BLACK.toMultiValue()
            } else {
                Color.WHITE.toMultiValue()
            }

            wrappedCellStorage[wrappedCellStorage.indexOf(oldWrappedCell)] = wrappedCell

        }

    }
}

//TODO dynamic grid size
fun Color.toPaint() = Paint.valueOf(toString())
fun Color.toMultiValue() = MultiValue(arrayOf(toPaint()))