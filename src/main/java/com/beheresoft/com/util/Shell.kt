package com.beheresoft.com.util

class Shell private constructor() {

    companion object {
        fun exec(var cmd: String): String {
            Runtime.getRuntime().exec()
        }
    }

}