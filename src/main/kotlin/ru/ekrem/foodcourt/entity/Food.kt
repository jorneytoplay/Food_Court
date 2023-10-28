package ru.ekrem.foodcourt.entity

import jakarta.persistence.*

@Entity
@Table(name = "foods")
class Food(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    var name: String,
) {
    override fun toString(): String {
        return "Food(id=$id, name='$name')"
    }
}