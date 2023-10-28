package ru.ekrem.foodcourt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FoodCourtApplication

fun main(args: Array<String>) {
    runApplication<FoodCourtApplication>(*args)
}
