package com.todo.todolist.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.todolist.entity.Todo;
import com.todo.todolist.service.TodoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    
    @PostMapping
    List<Todo> criarTarefa(@RequestBody @Valid Todo todo) {
        return todoService.criarTarefa(todo);
    }

    @GetMapping
    List<Todo> listarTarefas() {
        return todoService.listarTarefa();
    }

    @PutMapping
    List<Todo> atualizarTarefa(Todo todo) {
        return todoService.atualizarTarefa(todo);
    } 

    @DeleteMapping("{id}")
    List<Todo> apagarTarefa(@PathVariable("id") Long id) {
        return todoService.apagarTarefa(id);
    }

}
