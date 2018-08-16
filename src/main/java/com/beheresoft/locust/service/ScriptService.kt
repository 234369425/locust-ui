package com.beheresoft.locust.service

import com.beheresoft.locust.pojo.TestCase
import com.beheresoft.locust.util.Shell
import com.google.common.io.Files
import org.springframework.stereotype.Service
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer
import java.nio.file.Paths

@Service
class ScriptService(private val freemarker: FreeMarkerConfigurer) {

    fun saveToDisk(baseInfo: TestCase) {
        var file = Paths.get("script.py").toFile()
        Files.touch(file)
        val result = genScript(baseInfo)
        Files.write(result.toByteArray(), file)
        print(Shell.exec("locust -f script.py -P 21956"))
    }

    fun genScript(baseInfo: TestCase): String {
        val template = freemarker.configuration.getTemplate("python.ftl")
        return FreeMarkerTemplateUtils.processTemplateIntoString(template, baseInfo)
    }

}