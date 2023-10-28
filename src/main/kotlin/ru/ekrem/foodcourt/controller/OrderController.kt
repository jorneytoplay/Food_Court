package ru.ekrem.foodcourt.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.ekrem.foodcourt.dto.OrderDto
import ru.ekrem.foodcourt.service.OrderService

@RestController
@RequestMapping("/order")
class OrderController {

    @Autowired
    lateinit var service: OrderService

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): OrderDto? = service.findById(id)

    @GetMapping()
    fun getAll(): List<OrderDto>? = service.findAll()

    @PostMapping()
    fun save(@RequestBody dto: OrderDto): OrderDto? = service.save(dto)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): Boolean = service.delete(id)
}