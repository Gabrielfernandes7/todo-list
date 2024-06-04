package com.todo.todolist.entity.dto;

public record UserRequestRegisterDTO(
    String nome, 
    String email, 
    String senha, 
    String role
) {
    
}
