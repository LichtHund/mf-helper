package me.mattstudios.mfhelper.visitor

import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiFile
import me.mattstudios.mfhelper.base.Gui
import me.mattstudios.mfhelper.controller.GuiController
import org.jetbrains.kotlin.idea.debugger.sequence.psi.resolveType
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.psi.KtTreeVisitorVoid
import org.jetbrains.kotlin.psi.KtValueArgumentList

/**
 * @author Matt
 */
class KotlinVisitor : PsiElementVisitor() {

    override fun visitFile(file: PsiFile) {
        super.visitFile(file)

        file.accept(object : KtTreeVisitorVoid() {
            override fun visitProperty(property: KtProperty) {
                super.visitProperty(property)

                if (!property.hasDelegateExpressionOrInitializer()) return
                val initializer = property.delegateExpressionOrInitializer ?: return
                val initializerType = initializer.resolveType()

                if (!GuiController.AVAILABLE_GUI.contains(initializerType.toString())) return

                val name = property.name ?: return

                val arguments = mutableMapOf<String, Any>()

                for (children in initializer.children) {
                    if (children !is KtValueArgumentList) continue

                    val valueArguments = children.arguments

                    for (i in 0 until valueArguments.size) {
                        val argument = valueArguments[i]

                        val argumentType = argument.getArgumentExpression()?.resolveType() ?: continue

                        when {

                            argumentType.toString() == "Int" -> {
                                arguments["rows"] = argument.text.toInt()
                            }

                            argumentType.toString() == "String" -> {
                                arguments["title"] = argument.text
                            }

                        }

                    }
                }

                GuiController.addGui(name, Gui.getGuiFromMap(arguments))
            }
        })

        GuiController.test()

    }

}