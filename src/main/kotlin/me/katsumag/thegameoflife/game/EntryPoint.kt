package me.katsumag.thegameoflife.game

class EntryPoint {

    fun populate(list: List<WrappedCell>) {
        val twoDList = mutableListOf(mutableListOf<WrappedCell>())
        val currentRow = mutableListOf<WrappedCell>()
        var current = 0
        list.forEach {
            if (it.button.text[3].toInt() == current) {
                currentRow.add(it)
            } else {
                current += 1
                twoDList.add(currentRow)
                currentRow.clear()
                currentRow.add(it)
            }
        }

        println(twoDList)

    }

}

fun main() {

}