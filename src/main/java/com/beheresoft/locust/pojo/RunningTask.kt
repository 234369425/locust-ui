package com.beheresoft.locust.pojo

import java.io.File
import java.util.*

data class RunningTask(val port: Int = 20000, val proc: Process, val folder: File, val startTime: Date?, val endTime: Date? = null)