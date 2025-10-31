package com.back.domain.wiseSaying.controller

import com.back.Rq
import com.back.domain.wiseSaying.entity.WiseSaying

class WiseSayingController {

    var lastId = 0
    val wiseSayings = mutableListOf<WiseSaying>()

    fun write() {
        print("명언: ")
        val content = readln().trim()

        print("작가: ")
        val author = readln().trim()
        val id = ++lastId

        wiseSayings.add(WiseSaying(id, content, author))
        println("${id}번 명언이 등록되었습니다.")
    }

    fun list()  {
        println("번호 / 작가 / 명언")
        println("----------------------")

        wiseSayings.reversed().forEach {
            println("${it.id} / ${it.author} / ${it.content}")
        }
    }

    fun delete(rq: Rq) {
        val id = rq.getParamValueAsInt("id", 0)

        if (id == 0) {
            println("id를 정확히 입력해주세요.")
            return
        }

        val wiseSaying = wiseSayings.firstOrNull {
            it.id == id
        }

        if (wiseSaying == null) {
            println("${id}번 명언은 존재하지 않습니다.")
            return
        }

        wiseSayings.remove(wiseSaying)
        println("${id}번 명언이 삭제되었습니다.")
    }
}