package com.beheresoft.locust.pojo

import com.beheresoft.locust.enums.Method
import com.fasterxml.jackson.databind.ObjectMapper

data class Requests(
        val method: Method = Method.GET,
        val uri: String,
        var name: String?,
        val weight: Int = 0,
        val params: List<HashMap<String, String>>?
) {
    constructor() : this(uri = "", name = null, params = null)

    fun getParams(): String {
        if (params == null) {
            return "[]"
        }
        val mapper = ObjectMapper()
        return mapper.writeValueAsString(params)
    }

    fun getParamsFirst(): String {
        val mapper = ObjectMapper()
        return mapper.writeValueAsString(params?.get(0))
    }

    fun getParamsSize(): Int {
        if (params == null) {
            return 0
        }
        return params.size
    }
}