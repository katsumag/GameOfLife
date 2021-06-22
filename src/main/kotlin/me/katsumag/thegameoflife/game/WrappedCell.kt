package me.katsumag.thegameoflife.game

import javafx.scene.control.Button

data class WrappedCell(val cell: Cell, val button: Button)

val wrappedCellStorage = mutableListOf<WrappedCell>()