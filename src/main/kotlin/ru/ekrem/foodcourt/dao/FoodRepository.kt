package ru.ekrem.foodcourt.dao

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.ekrem.foodcourt.entity.Food

@Repository
interface FoodRepository : JpaRepository<Food, Long> {
    fun findAllByNameIn(foods: List<String>): List<Food>
}