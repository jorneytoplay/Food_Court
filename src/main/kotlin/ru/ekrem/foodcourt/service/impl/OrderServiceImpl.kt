package ru.ekrem.foodcourt.service.impl

import jakarta.transaction.Transactional
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import ru.ekrem.foodcourt.dao.FoodRepository
import ru.ekrem.foodcourt.dao.OrderRepository
import ru.ekrem.foodcourt.dto.OrderDto
import ru.ekrem.foodcourt.entity.Order
import ru.ekrem.foodcourt.service.OrderService

@Service
class OrderServiceImpl : OrderService {

    @Autowired
    lateinit var repository: OrderRepository

    @Autowired
    lateinit var foodRepository: FoodRepository

    val modelMapper = ModelMapper()

    override fun findById(id: Long): OrderDto =
        modelMapper
            .map(repository.getOrderById(id), OrderDto::class.java)

    override fun findAll(): List<OrderDto> =
        repository
            .findAll()
            .map { order -> modelMapper.map(order, OrderDto::class.java) }


    @Transactional
    override fun save(dto: OrderDto): OrderDto {
        val foodsInDb = foodRepository.findAllByNameIn(dto.foods.map { food -> food.name })
        val order: Order = modelMapper.map(dto, Order::class.java).apply { this.foods = foodsInDb }
        return modelMapper.map(repository.save(order), OrderDto::class.java)

    }

    override fun delete(id: Long): Boolean {
        val order = repository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Food with id $id not found") }
        repository.delete(order)
        return true
    }

}
