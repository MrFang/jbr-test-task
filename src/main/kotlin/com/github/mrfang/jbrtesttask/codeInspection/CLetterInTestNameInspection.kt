package com.github.mrfang.jbrtesttask.codeInspection

import com.github.mrfang.jbrtesttask.MessagesBundle
import com.github.mrfang.jbrtesttask.service.DataService
import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.openapi.components.service
import com.intellij.psi.PsiElementVisitor
import com.jetbrains.python.psi.PyClass
import com.jetbrains.python.psi.PyElementVisitor
import com.jetbrains.python.psi.PyFunction

class CLetterInTestNameInspection: LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object: PyElementVisitor() {
            override fun visitPyClass(clazz: PyClass)  {
                super.visitPyClass(clazz)

                val fullClassName = clazz.containingFile.name + "." + clazz.name
                val dataService = clazz.project.service<DataService>()
                dataService.resetProblemsCount(fullClassName)

                if (clazz.superClassExpressions.map { expr -> expr.name }.contains("TestCase")) {
                    clazz.visitMethods(
                        fun (func: PyFunction): Boolean {
                            if (func.name != null
                                && func.name!!.startsWith("test_")
                                && func.name!!.contains('c')
                            ) {
                                holder.registerProblem(func, MessagesBundle.message("WarningMessage"))
                                dataService.increaseProblemsCount(fullClassName)
                            }

                            return true
                        },
                        false,
                        null
                    )
                }
            }
        }
    }
}