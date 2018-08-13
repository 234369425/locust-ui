package com.beheresoft.locust.service

import com.beheresoft.locust.pojo.BaseInfo
import org.springframework.stereotype.Service
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer

@Service
class ScriptService(private val freemarker: FreeMarkerConfigurer) {

    fun genScript(baseInfo: BaseInfo): String {
        val template = freemarker.configuration.getTemplate("python.ftl")
        return FreeMarkerTemplateUtils.processTemplateIntoString(template, baseInfo)
    }

}