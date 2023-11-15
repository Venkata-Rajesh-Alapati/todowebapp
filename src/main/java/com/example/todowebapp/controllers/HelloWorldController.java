package com.example.todowebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
	
	static String HTML = """
			
			<html>
				<head>
					<title> HTML Message</title>
				</head>
				<body>
					<h1>HTML Heading</h1>
					<p>Hello from html</p>
				</body>	
			</html>
			""";

	@RequestMapping("/hello")
	@ResponseBody
	public String message() {
		return "Hello from webapp";
	}
	
	
	@RequestMapping("/hellohtml")
	@ResponseBody
	public String htmlmessage() {
		return HTML;
	}
	

	@RequestMapping("/hello-html-jsp")
	public String htmlMessageJsp() {
		return "/HelloView";
	}
	
}
