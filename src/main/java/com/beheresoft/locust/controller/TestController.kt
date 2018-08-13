package com.beheresoft.locust.controller

import com.beheresoft.locust.pojo.BaseInfo
import com.beheresoft.locust.pojo.Requests
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/test")
class TestController {

    @RequestMapping("/test")
    fun test(@RequestBody info: BaseInfo): ModelAndView {
        return ModelAndView("test")
    }
}
