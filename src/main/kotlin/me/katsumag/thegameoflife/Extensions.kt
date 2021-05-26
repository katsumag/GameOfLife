package me.katsumag.thegameoflife

import javax.swing.JFrame

fun runnable(function: Runnable.() -> Unit): Runnable {
    return object: Runnable {
        override fun run() {
            function()
        }
    }
}

inline fun JFrame.transform(transformer: JFrame.() -> Unit): JFrame {
    this.transformer()
    return this
}