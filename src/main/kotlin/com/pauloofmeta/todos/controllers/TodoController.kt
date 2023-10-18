package com.pauloofmeta.todos.controllers

import com.pauloofmeta.todos.entities.Todo
import com.pauloofmeta.todos.repositories.TodoRepository
import jakarta.persistence.EntityNotFoundException
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/todos")
class TodoController {
    @Autowired
    lateinit var repository: TodoRepository

    @GetMapping
    fun all(): List<Todo> {
        return repository.findAll()
    }

    @PostMapping
    fun create(@Valid @RequestBody todo: Todo): Todo {
       return repository.save(todo);
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody newTodo: Todo): Todo {
        val todo = repository.findById(id).orElseThrow { EntityNotFoundException() }

        todo.apply{
            this.name = newTodo.name
            this.completed = newTodo.completed
        }
        return repository.save(todo);
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long) {
        repository.deleteById(id);
    }
}