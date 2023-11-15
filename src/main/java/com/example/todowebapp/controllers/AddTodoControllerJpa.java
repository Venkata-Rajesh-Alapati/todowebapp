package com.example.todowebapp.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.todowebapp.beans.ToDo;
import com.example.todowebapp.services.ToDoDataJpa;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class AddTodoControllerJpa {
	
	@Autowired
	ToDoDataJpa todoService;
	
	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String addTodo(ModelMap model) {
		ToDo todo = new ToDo(0, "","" , LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "addtodo";
	}
	
	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addTodoPost(ModelMap model,@Valid @ModelAttribute("todo") ToDo todo, BindingResult res) {
		if(res.hasErrors()) {
			return "addtodo";
		}
		String username = (String) model.get("name");
		todo.setUsername(username);
		todoService.save(todo);
		return "redirect:todos";
	}
	
	@RequestMapping(value = "delete-todo")
	public String deleteTodo(ModelMap model, @RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:todos";
	}
	
	@RequestMapping(value = "update-todo")
	public String updateTodo(ModelMap model, @RequestParam int id) {
		ToDo todo = todoService.getById(id);
		model.put("todo", todo);
		return "addtodo";
	}
	
	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateTodoPost(ModelMap model,@Valid @ModelAttribute("todo") ToDo todo, BindingResult res) {
		if(res.hasErrors()) {
			return "addtodo";
		}
		String username = (String) model.get("name");
		todo.setUsername(username);
		todoService.save(todo);
		return "redirect:todos";
	}
	

}
