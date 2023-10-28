package ru.ekrem.foodcourt.dao

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.ekrem.foodcourt.entity.Order

@Repository
interface OrderRepository : JpaRepository<Order, Long> {
    fun save(order: Order): Order?
    fun getOrderById(id: Long): Order?
}
