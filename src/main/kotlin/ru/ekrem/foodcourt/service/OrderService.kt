package ru.ekrem.foodcourt.service

import ru.ekrem.foodcourt.dto.OrderDto

interface OrderService {
    fun findById(id: Long): OrderDto
    fun findAll(): List<OrderDto>
    fun save(dto: OrderDto): OrderDto
    fun delete(id: Long): Boolean
}