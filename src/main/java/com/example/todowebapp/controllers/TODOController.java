package com.example.todowebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.todowebapp.services.ToDoDataJpa;

@Controller
@SessionAttributes("name")
public class TODOController {

	@Autowired
	ToDoDataJpa toDoObj;
	
	@RequestMapping("todos")
	public String getToDos(ModelMap model) {
		model.put("todos", toDoObj.findByUsername((String)model.getAttribute("name")));
		return "todo";
	}
	
}
