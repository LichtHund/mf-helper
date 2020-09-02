package me.mattstudios.mfhelper.inspection

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import me.mattstudios.mfhelper.visitor.KotlinVisitor


class KotlinInspection : LocalInspectionTool() {

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean) = KotlinVisitor()

}