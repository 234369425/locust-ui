package com.beheresoft.locust.pojo

data class BaseInfo(val domain: String,
                    val minWait: Int = 500,
                    val maxWait: Int = 5000,
                    val requests: ArrayList<Requests>
)