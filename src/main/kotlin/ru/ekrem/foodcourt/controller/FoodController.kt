package ru.ekrem.foodcourt.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.ekrem.foodcourt.dto.FoodDto
import ru.ekrem.foodcourt.service.FoodService

@RestController
@RequestMapping("/food")
class FoodController {

    @Autowired
    lateinit var service: FoodService

    @GetMapping("/{id}")
    fun getOne(@PathVariable id: Long): FoodDto = service.getById(id)

    @GetMapping
    fun getAll(): List<FoodDto> = service.getAll()

    @PostMapping
    fun create(@RequestBody foodDto: FoodDto): FoodDto = service.save(foodDto)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody foodDto: FoodDto): FoodDto {
        foodDto.id = id
        return service.put(foodDto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): Boolean = service.delete(id)
}
