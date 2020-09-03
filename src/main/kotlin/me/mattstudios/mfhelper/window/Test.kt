package me.mattstudios.mfhelper.window

import com.google.gson.Gson
import com.intellij.ui.jcef.JBCefBrowser
import me.mattstudios.mfhelper.controller.GuiController
import javax.swing.JComponent


/**
 * @author Matt
 */
object Test {
    private val gson = Gson()

    private val myJBCefBrowser = JBCefBrowser()

    private val html = Test::class.java.getResourceAsStream("/browser/test.html").bufferedReader().use { it.readText() }

    fun create(): JComponent {

        /*val myJSQueryOpenInBrowser = JBCefJSQuery.create(myJBCefBrowser)

        Disposer.dispose(myJSQueryOpenInBrowser)*/
        //jPanel.add(myJBCefBrowser.component)

        myJBCefBrowser.loadURL("http://localhost:8080/viewer")

        return myJBCefBrowser.component
    }

    fun update() {
        val data = gson.toJson(GuiController.activeGui)
        myJBCefBrowser.loadURL("http://localhost:8080/viewer?data=$data")
    }

}