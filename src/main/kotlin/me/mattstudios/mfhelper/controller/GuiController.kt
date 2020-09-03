package me.mattstudios.mfhelper.controller

import me.mattstudios.mfhelper.base.Gui

/**
 * @author Matt
 */
object GuiController {

    val AVAILABLE_GUI = listOf("Gui", "PaginatedGui")
    private val activeGui = mutableMapOf<String, Gui>()

    fun addGui(name: String, gui: Gui) {
        activeGui[name] = gui
    }

    fun removeGui(name: String) {
        activeGui.remove(name)
    }

    fun getGui(name: String): Gui? {
        return activeGui[name]
    }

    fun test() {
        println(activeGui)
    }

}