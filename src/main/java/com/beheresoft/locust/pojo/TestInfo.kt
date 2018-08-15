package com.beheresoft.locust.pojo

data class TestInfo(val domain: String,
                    val minWait: Int = 500,
                    val maxWait: Int = 5000,
                    val start: ArrayList<Requests>?,
                    val requests: ArrayList<Requests>
)