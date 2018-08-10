package com.beheresoft.com.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/test")
class TestController {

    @RequestMapping("/test")
    fun test(): ModelAndView {
        return ModelAndView("test")
    }
}
