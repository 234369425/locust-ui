package com.beheresoft.com.util

import java.io.BufferedReader
import java.io.InputStreamReader

class Shell private constructor() {

    companion object {

        fun execSilent(cmd: String) {
            var process = Runtime.getRuntime().exec(cmd)
            process.waitFor()
        }

        fun exec(cmd: String): String {
            var result = StringBuilder()
            val process = Runtime.getRuntime().exec(cmd)
            var input = BufferedReader(InputStreamReader(process.inputStream))
            for (line in input.lines()) {
                result.append(line)
            }
            input.close()
            return result.toString()
        }


    }

}