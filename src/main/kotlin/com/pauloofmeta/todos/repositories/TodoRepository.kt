package com.pauloofmeta.todos.repositories

import com.pauloofmeta.todos.entities.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository: JpaRepository<Todo, Long> {
}