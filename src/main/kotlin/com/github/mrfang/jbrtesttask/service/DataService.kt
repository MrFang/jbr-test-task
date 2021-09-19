package com.github.mrfang.jbrtesttask.service

import com.intellij.openapi.project.Project


class DataService(private val project: Project) {
    private val problemsInClasses = mutableMapOf<String, Int>()

    fun getProblemsCount(className: String): Int {
        return problemsInClasses[className] ?: 0
    }

    fun increaseProblemsCount(className: String) {
        if (problemsInClasses[className] == null) {
            problemsInClasses[className] = 1
        } else {
            problemsInClasses[className] = problemsInClasses[className]!! + 1
        }
    }

    fun resetProblemsCount(className: String) {
        problemsInClasses[className] = 0;
    }
}