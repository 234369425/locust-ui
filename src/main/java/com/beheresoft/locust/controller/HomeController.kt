package com.beheresoft.locust.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/")
class HomeController {

    @RequestMapping("/")
    fun home(): ModelAndView {
        var mv = ModelAndView("index")
        return mv
    }
}
