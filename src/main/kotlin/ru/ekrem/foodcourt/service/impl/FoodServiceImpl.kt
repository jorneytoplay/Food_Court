package ru.ekrem.foodcourt.service.impl

import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import ru.ekrem.foodcourt.dao.FoodRepository
import ru.ekrem.foodcourt.dto.FoodDto
import ru.ekrem.foodcourt.entity.Food
import ru.ekrem.foodcourt.service.FoodService


@Service
class FoodServiceImpl : FoodService {

    @Autowired
    lateinit var repository: FoodRepository
    val modelMapper = ModelMapper()

    override fun getById(id: Long): FoodDto = modelMapper.map(repository.findById(id), FoodDto::class.java)

    override fun getAll(): List<FoodDto> = repository.findAll()
        .map { food -> modelMapper.map(food, FoodDto::class.java) }

    override fun save(dto: FoodDto): FoodDto =
        modelMapper.map(repository.save(modelMapper.map(dto, Food::class.java)), FoodDto::class.java)


    override fun put(dto: FoodDto): FoodDto {
        repository.findById(dto.id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Not found food with ${dto.id} id") }
        return modelMapper.map(repository.save(modelMapper.map(dto, Food::class.java)), FoodDto::class.java)
    }

    override fun delete(id: Long): Boolean {
        val food = repository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Food with id $id not found") }
        repository.delete(food)
        return true
    }


}