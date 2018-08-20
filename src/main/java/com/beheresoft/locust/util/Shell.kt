package com.beheresoft.locust.util

import java.io.BufferedReader
import java.io.InputStreamReader

class Shell private constructor() {

    companion object {
        fun execSilent(cmd: String) {
            var process = Runtime.getRuntime().exec(cmd)
            process.waitFor()
        }

        fun start(name: String, port: Int) {
            exec(genCmd(name, port))
        }

        private fun genCmd(name: String, port: Int): String {
            var shell = System.getProperty("os.name")
            var cmd: String
            if (shell.indexOf("Windows") >= 0) {
                cmd = "start start.cmd $name $port "
            } else {
                cmd = "nohup locust -f $name -P $port"
            }
            return cmd
        }

        private fun exec(cmd: String): String {
            var result = StringBuilder()
            val process = Runtime.getRuntime().exec(cmd)
            var input = BufferedReader(InputStreamReader(process.inputStream))
            for (line in input.lines()) {
                print(line)
                result.append(line)
            }
            input.close()
            return result.toString()
        }
    }


}