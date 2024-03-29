package com.todo.todolist.entity;

import com.todo.todolist.entity.dto.TodoRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

// cria entidade Todo é nossa tabela
// nome da nossa tabela é todos
@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank // não pode ser em branco
    private String nome;

    @NotBlank // Não pode ser em branco
    private String descricao;

    private boolean realizado;
    private int prioridade;

    public Todo() {
    }

    public Todo(String nome, String descricao, boolean realizado, int prioridade) {
        this.nome = nome;
        this.descricao = descricao;
        this.realizado = realizado;
        this.prioridade = prioridade;
    }

    public Todo(Long id, String nome, String descricao, boolean realizado, int prioridade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.realizado = realizado;
        this.prioridade = prioridade;
    }

    public Todo(TodoRequestDTO todoData) {
        this.nome = todoData.nome();
        this.descricao = todoData.descricao();
        this.prioridade = todoData.prioridade();
        this.realizado = todoData.realizado();
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

}
