package com.example.springboottodo.controller;

import com.example.springboottodo.dto.ToDoDto;
import com.example.springboottodo.model.ToDo;
import com.example.springboottodo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = {"/", ""})
public class ToDoController {
    @Autowired
    private ToDoService toDoService;


    @GetMapping("/{id}")
    public String getToDo(@PathVariable("id") Long id, Model model) {
        Optional<ToDo> optionalToDo = toDoService.findById(id);

        ToDo todo = optionalToDo.get();
        model.addAttribute("todo", todo);
        return "todo";
    }

    // okay
    @GetMapping(value={"/", ""})
    public String findAllTodo(Model model) {
        List<ToDo> todoList = toDoService.findAll();
        model.addAttribute("todoList", todoList);
//        return "redirect:/list";
        return "list";
    }

    @PostMapping(value={"/", ""})
    public String createTodo(@ModelAttribute ToDoDto todoCreateDto) {
        ToDo newTodo = new ToDo();
        newTodo.setTitle(todoCreateDto.getTitle());
        newTodo.setDescription(todoCreateDto.getDescription());
        newTodo.setCompleted(false);
        newTodo.setStarred(false);
        toDoService.save(newTodo);
        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    public String updateToDo(@PathVariable("id") Long id, @ModelAttribute ToDoDto toDoDto) {
        Optional<ToDo> optionalToDo = toDoService.findById(id);

        if (optionalToDo.isEmpty()) {
            return "error";
        }

        ToDo todo = optionalToDo.get();

        if(toDoDto.getTitle() != null) todo.setTitle(toDoDto.getTitle());
        if(toDoDto.getDescription() != null)todo.setDescription(toDoDto.getDescription());
        if(toDoDto.getCompleted() != null)todo.setCompleted(toDoDto.getCompleted());
        if(toDoDto.getStarred() != null)todo.setStarred(toDoDto.getStarred());

        toDoService.save(todo);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteToDo(@PathVariable("id") Long id) {
        Optional<ToDo> optionalToDo = toDoService.findById(id);

        ToDo todo = optionalToDo.get();
        toDoService.deleteById(id);
        return "redirect:/";
    }
}
