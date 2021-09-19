package com.github.mrfang.jbrtesttask.toolWindow

import com.github.mrfang.jbrtesttask.service.DataService
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import javax.swing.JLabel
import javax.swing.JPanel

// TODO: Получать обновления из сервиса постоянно
class ReportToolWindow(private val project: Project) {
    lateinit var content: JPanel
    lateinit var label: JLabel
    lateinit var problemCount: JLabel

    init {
        getProblemCount()
    }

    private fun getProblemCount() {
        val service = project.service<DataService>()
        // TODO: Получить имя открытого файла, и обновить `problemCount`
    }
}