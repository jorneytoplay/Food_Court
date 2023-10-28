package ru.ekrem.foodcourt.entity

import jakarta.persistence.*
import ru.ekrem.foodcourt.enums.OrderStatus

@Entity
@Table(name = "orders")
class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val customer_uuid: Long,
    @Enumerated(EnumType.STRING)
    var status: OrderStatus,

    @ManyToMany
    @JoinTable(
        name = "food_order_relation",
        joinColumns = [JoinColumn(name = "order_id")],
        inverseJoinColumns = [JoinColumn(name = "food_id")]
    )
    var foods: List<Food>
) {
    override fun toString(): String {
        return "Order(id=$id, customer_uuid=$customer_uuid, status=$status, foods=$foods)"
    }
}