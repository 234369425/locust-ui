package com.beheresoft.locust.util

class Machine private constructor() {

    companion object {
        private var cup = Runtime.getRuntime().availableProcessors()

        fun getCpus(): Int {
            return cup
        }

    }
}