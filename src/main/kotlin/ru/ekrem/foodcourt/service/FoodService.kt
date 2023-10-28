package ru.ekrem.foodcourt.service

import ru.ekrem.foodcourt.dto.FoodDto

interface FoodService {
    fun getById(id: Long): FoodDto
    fun getAll(): List<FoodDto>
    fun save(dto: FoodDto): FoodDto
    fun put(dto: FoodDto): FoodDto
    fun delete(id: Long): Boolean

}