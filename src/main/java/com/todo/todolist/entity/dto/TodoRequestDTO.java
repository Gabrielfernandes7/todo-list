package com.todo.todolist.entity.dto;

public record TodoRequestDTO(String nome, String descricao, boolean realizado, Integer prioridade) {
}
