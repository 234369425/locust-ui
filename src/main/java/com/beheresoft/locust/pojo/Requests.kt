package com.beheresoft.locust.pojo

import com.beheresoft.locust.enums.Method

data class Requests(
        val method: Method = Method.GET,
        val uri: String,
        val params: Map<String, String>?
)