package me.mattstudios.mfhelper.window

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import me.mattstudios.mfhelper.form.TestToolWindow

/**
 * @author Matt
 */
class GuiWindowFactory : ToolWindowFactory {

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val contentFactory = ContentFactory.SERVICE.getInstance()
        val content = contentFactory.createContent(TestToolWindow(toolWindow).panel, "", false)
        toolWindow.contentManager.addContent(content)
    }

}