package com.beheresoft.com.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/")
class HomeController {

    @RequestMapping("/")
    fun home(): ModelAndView {
        return ModelAndView("index")
    }
}