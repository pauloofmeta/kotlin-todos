package com.pauloofmeta.todos.entities

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
@Table(name = "todos")
class Todo (
        @field:Id
        @field:GeneratedValue(strategy = GenerationType.IDENTITY)
        val id:Long,

        @field:NotNull
        @field:Size(min = 3, max = 200)
        var name: String,

        @field:NotNull
        var completed: Boolean
)