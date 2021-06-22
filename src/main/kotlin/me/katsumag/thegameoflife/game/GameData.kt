package me.katsumag.thegameoflife.game

object GameData {

    private val _gameData = mutableListOf(mutableListOf<WrappedCell>())

    val gameData: List<List<WrappedCell>>
        get() = _gameData.toList()

    fun updateCell(cell: WrappedCell) = _gameData[cell.cell.position.y].set(cell.cell.position.x, cell)

}
