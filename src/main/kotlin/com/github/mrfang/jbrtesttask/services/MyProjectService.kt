package com.github.mrfang.jbrtesttask.services

import com.intellij.openapi.project.Project
import com.github.mrfang.jbrtesttask.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
