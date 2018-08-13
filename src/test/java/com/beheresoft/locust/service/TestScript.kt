package com.beheresoft.locust.service

import com.beheresoft.locust.Application
import com.beheresoft.locust.pojo.BaseInfo
import com.beheresoft.locust.pojo.Requests
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(
        classes = arrayOf(Application::class),
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestScript {

    @Autowired
    lateinit var scriptService: ScriptService

    @Test
    fun testTemplate() {
        val list = ArrayList<Requests>()
        list.add(Requests(uri = "/cde", params = null))
        println(scriptService.genScript(BaseInfo(domain = "www.baidu.com", requests = list)))
    }

}