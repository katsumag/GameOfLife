package me.katsumag.thegameoflife.game

data class Position(val x: Int, val y: Int) {
    constructor(pair: Pair<Int, Int>) : this(pair.first, pair.second)
}