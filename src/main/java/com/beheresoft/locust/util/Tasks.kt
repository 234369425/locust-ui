package com.beheresoft.locust.util

import java.util.concurrent.atomic.AtomicInteger


class Tasks private constructor() {

    companion object {
        private val tasks: Tasks = Tasks()
        fun get(): Tasks {
            return tasks
        }
    }

    private val tasks = HashMap<Int, Process>()
    private val port = AtomicInteger(20000)

    fun getPort(): Int {
        return port.incrementAndGet()
    }

    fun regTask(id: Int, p: Process) {
        tasks[id] = p
    }

    fun ListTask(): Set<Int> {
        return tasks.keys
    }

    fun stop(id: Int) {
        tasks[id]?.destroy()
    }

}