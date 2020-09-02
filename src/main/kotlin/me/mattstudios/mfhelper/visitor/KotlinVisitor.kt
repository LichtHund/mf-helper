package me.mattstudios.mfhelper.visitor

import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiFile
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.psi.KtTreeVisitorVoid

/**
 * @author Matt
 */
class KotlinVisitor : PsiElementVisitor() {

    override fun visitFile(file: PsiFile) {
        super.visitFile(file)

        file.accept(object : KtTreeVisitorVoid() {
            override fun visitProperty(property: KtProperty) {
                super.visitProperty(property)
                println("$property - ${property.text}")
            }
        })

    }

}