package me.mattstudios.mfhelper.window

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import com.intellij.ui.jcef.JBCefApp

/**
 * @author Matt
 */
class GuiWindowFactory : ToolWindowFactory {

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val contentFactory = ContentFactory.SERVICE.getInstance()

        if (!JBCefApp.isSupported()) return
        println("is supported")
        //val test = Test()

        val content = contentFactory.createContent(Test.create(), "", false)
        toolWindow.contentManager.addContent(content)
    }

}