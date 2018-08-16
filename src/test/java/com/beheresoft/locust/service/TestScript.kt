package com.beheresoft.locust.service

import com.beheresoft.locust.Application
import com.beheresoft.locust.enums.Method
import com.beheresoft.locust.pojo.TestCase
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
        list.add(Requests(uri = "/cde", params = null, name = "test"))
        val m = HashMap<String, String>()
        m.put("123", "123")
        val l = ArrayList<HashMap<String, String>>();
        l.add(m)
        list.add(Requests(uri = "/def", params = l, name = "post", weight = 10))
        println(scriptService.genScript(TestCase(domain = "www.baidu.com", requests = list, start = null)))
    }

}