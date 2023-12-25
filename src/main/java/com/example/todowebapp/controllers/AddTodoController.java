package com.example.todowebapp.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.todowebapp.beans.ToDo;
import com.example.todowebapp.services.ToDoService;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class AddTodoController {
	
	@Autowired
	ToDoService todoService;
	
	@GetMapping(value = "add-todo")
	public String addTodo(ModelMap model) {
		ToDo todo = new ToDo(0, "","" , LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "addtodo";
	}
	
	@PostMapping(value = "add-todo")
	public String addTodoPost(ModelMap model,@Valid @ModelAttribute("todo") ToDo todo, BindingResult res) {
		if(res.hasErrors()) {
			return "addtodo";
		}
		String username = (String) model.get("name");
		todoService.addToDo(username,todo.getDescription() , todo.getTargetDate(), false);
		return "redirect:todos";
	}
	
	@RequestMapping(value = "delete-todo")
	public String deleteTodo(ModelMap model, @RequestParam int id) {
		todoService.deleteToDo(id);
		return "redirect:todos";
	}
	
	@RequestMapping(value = "update-todo")
	public String updateTodo(ModelMap model, @RequestParam int id) {
		ToDo todo = todoService.getToDo(id);
		model.put("todo", todo);
		return "addtodo";
	}
	
	@PostMapping(value = "update-todo")
	public String updateTodoPost(ModelMap model,@Valid @ModelAttribute("todo") ToDo todo, BindingResult res) {
		if(res.hasErrors()) {
			return "addtodo";
		}
		todoService.update(todo);
		return "redirect:todos";
	}
	

}
