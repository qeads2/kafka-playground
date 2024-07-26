package com.example.kafkaplayground

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaPlaygroundApplication

fun main(args: Array<String>) {
    runApplication<KafkaPlaygroundApplication>(*args)
}
