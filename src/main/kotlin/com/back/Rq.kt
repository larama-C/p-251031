package com.back

class Rq(
    val cmd: String
) {

    val action: String
    private val paramMap: Map<String, String>

    init {

        val cmdBits = cmd.split("?")
        action = cmdBits[0]

        paramMap = if (cmdBits.size == 2) {

            cmdBits[1]
                .split("&")
                .map {  // aaa=bbb
                    val paramBits = it.split("=")
                    paramBits[0] to paramBits[1]
                }
                .toMap()
        } else {
            emptyMap()
        }
    }

    fun getParamValue(key: String): String {
        return paramMap[key]!!
    }

}