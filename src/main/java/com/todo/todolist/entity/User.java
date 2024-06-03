package com.todo.todolist.entity;
import com.todo.todolist.entity.dto.UserRequestRegisterDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String senha;

    private String role;

    public User() {
    }

    public User(
        Long id, 
        String nome, 
        String email, 
        String senha, 
        String role
    ) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.role = role;
    }

    public User(UserRequestRegisterDTO userData) {
        this.nome = userData.nome();
        this.email = userData.email();
        this.senha = userData.senha();
        this.role = userData.role();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
