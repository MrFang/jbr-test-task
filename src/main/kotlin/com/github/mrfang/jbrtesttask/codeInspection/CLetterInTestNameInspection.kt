package com.github.mrfang.jbrtesttask.codeInspection

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.jetbrains.python.psi.PyElementVisitor

class CLetterInTestNameInspection: LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return PyElementVisitor()
    }
}