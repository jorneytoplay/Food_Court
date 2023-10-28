package ru.ekrem.foodcourt.dto

import com.fasterxml.jackson.annotation.JsonProperty
import ru.ekrem.foodcourt.util.NoArg

@NoArg
data class FoodDto(
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    var id: Long,
    var name: String
)