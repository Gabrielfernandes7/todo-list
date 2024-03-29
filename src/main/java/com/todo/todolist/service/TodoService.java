package com.todo.todolist.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.todo.todolist.entity.Todo;
import com.todo.todolist.entity.dto.TodoRequestDTO;
import com.todo.todolist.entity.dto.TodoResponseDTO;
import com.todo.todolist.repository.TodoRepository;

import java.util.List;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    // injeção de dependências
    private TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void criarTarefa(TodoRequestDTO data) {

        Todo todoData = new Todo(data);

        todoRepository.save(todoData);
        return;
    }

    public List<TodoResponseDTO> listarTarefa() {
        // consulta ordenada por prioridades de forma descendente
        Sort sort = Sort.by("prioridade").descending().and(
            Sort.by("nome").ascending()
        );

        return todoRepository.findAll(sort).stream()
                                           .map(TodoResponseDTO::new)
                                           .toList();
    }

    public List<TodoResponseDTO> atualizarTarefa(Todo todo) {
        todoRepository.save(todo);

        return listarTarefa();
    }

    public List<TodoResponseDTO> apagarTarefa(Long id) {
        todoRepository.deleteById(id);
        
        return listarTarefa();
    }
}
