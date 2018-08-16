package com.beheresoft.locust.pojo

data class TestCase constructor(var domain: String,
                                var minWait: Int? = 500,
                                var maxWait: Int? = 5000,
                                var start: ArrayList<Requests>?,
                                var requests: ArrayList<Requests>?) {
    constructor() : this(domain = "", start = null, requests = null)
}
