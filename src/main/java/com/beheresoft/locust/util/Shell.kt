package com.beheresoft.locust.util

class Shell private constructor() {

    companion object {

        fun execSilent(cmd: String) {
            var process = Runtime.getRuntime().exec(cmd)
            process.waitFor()
        }

        fun exec(cmd: String): Process? {
            return try {
                Runtime.getRuntime().exec(cmd)
            } catch (e: Exception) {
                null
            }
        }
    }


}