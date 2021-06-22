package me.katsumag.thegameoflife.tornadofx

import tornadofx.App
import tornadofx.launch

class MyApp : App(MasterView::class)

fun main(args: Array<String>) = launch<MyApp>(args)