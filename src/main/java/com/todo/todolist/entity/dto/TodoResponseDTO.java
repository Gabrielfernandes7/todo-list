package com.todo.todolist.entity.dto;

import com.todo.todolist.entity.Todo;

public record TodoResponseDTO(Long id, String nome, String descricao, boolean realizado, Integer prioridade) {
    public TodoResponseDTO(Todo todo) {
        this(
            todo.getId(), 
            todo.getNome(), 
            todo.getDescricao(), 
            todo.isRealizado(), 
            todo.getPrioridade()
        );
    }
}
