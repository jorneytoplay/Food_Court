package ru.ekrem.foodcourt.dto

import ru.ekrem.foodcourt.enums.OrderStatus
import ru.ekrem.foodcourt.util.NoArg

@NoArg
data class OrderDto(
    var id: Long?,
    var customerUuid: Long?,
    var orderStatus: OrderStatus?,
    var foods: Array<FoodDto>
)
