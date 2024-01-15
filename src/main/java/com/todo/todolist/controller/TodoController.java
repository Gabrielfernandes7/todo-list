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

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    
    @Operation(summary = "Criar uma tarefa", description = "Cria uma nova tarefa")
    @PostMapping
    List<Todo> criarTarefa(@RequestBody @Valid Todo todo) {
        return todoService.criarTarefa(todo);
    }

    @Operation(summary = "Mostrar tarefas", description = "Mostra todas tarefas")
    @GetMapping
    List<Todo> listarTarefas() {
        return todoService.listarTarefa();
    }

    @Operation(summary = "Atualizar dados de tarefa", description = "Atualiza dados da tarefa")
    @PutMapping
    List<Todo> atualizarTarefa(Todo todo) {
        return todoService.atualizarTarefa(todo);
    } 

    @Operation(summary = "Apagar tarefa", description = "Apaga tarefa")
    @DeleteMapping("{id}")
    List<Todo> apagarTarefa(@PathVariable("id") Long id) {
        return todoService.apagarTarefa(id);
    }

}
