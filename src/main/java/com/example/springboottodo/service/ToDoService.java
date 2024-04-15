package com.example.springboottodo.service;

import com.example.springboottodo.model.ToDo;
import com.example.springboottodo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;

    public Optional<ToDo> findById(Long id) {
        return toDoRepository.findById(id);
    }

    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    public ToDo save(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public void deleteById(Long id) {
        toDoRepository.deleteById(id);
    }
}
