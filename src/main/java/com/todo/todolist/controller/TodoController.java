package com.todo.todolist.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.todolist.entity.Todo;
import com.todo.todolist.entity.dto.TodoRequestDTO;
import com.todo.todolist.entity.dto.TodoResponseDTO;
import com.todo.todolist.service.TodoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    
    @Operation(summary = "Criar uma tarefa", description = "Cria uma nova tarefa")
    @PostMapping
    public ResponseEntity<Void> criarTarefa(@RequestBody @Valid TodoRequestDTO todo) {
        todoService.criarTarefa(todo);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Mostrar tarefas", description = "Mostra todas tarefas")
    @GetMapping
    public ResponseEntity<List<TodoResponseDTO>> listarTarefas() {
        return ResponseEntity.ok(todoService.listarTarefa());
    }

    @Operation(summary = "Atualizar dados de tarefa", description = "Atualiza dados da tarefa")
    @PutMapping
    public ResponseEntity<List<TodoResponseDTO>> atualizarTarefa(@RequestBody @Valid Todo todo) {
        return ResponseEntity.ok(todoService.atualizarTarefa(todo));
    }

    @Operation(summary = "Atualizar parcialmente dados de tarefa", description = "Atualizar alguns campos de tarefas")
    @PatchMapping("/{id}")
    public ResponseEntity<TodoResponseDTO> atualizarAlgunsCampos(@PathVariable Long id, @RequestBody TodoRequestDTO data) {
        TodoResponseDTO updatedTodo = todoService.atualizarParcialTarefa(id, data);
        return ResponseEntity.ok(updatedTodo);
    }

    @Operation(summary = "Apagar tarefa", description = "Apaga tarefa")
    @DeleteMapping("/{id}")
    public ResponseEntity<List<TodoResponseDTO>> apagarTarefa(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.apagarTarefa(id));
    }
}
