package com.beheresoft.locust.controller

import com.beheresoft.locust.pojo.TestCase
import com.beheresoft.locust.service.ScriptService
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/test")
class TestController constructor(val service: ScriptService) {

    @RequestMapping("/create")
    fun test(param: String, mapper: ObjectMapper): ModelAndView {
        var ts = mapper.readValue<TestCase>(param)
        service.saveToDisk(ts)
        return ModelAndView("test")
    }
}
