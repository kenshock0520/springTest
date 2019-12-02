package com.example.springTest.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class ApiController {

	@GetMapping("/test1")
	public String test1() {
		log.info("確認メソッドきた1");
		return "comeTest1";
	}

	@GetMapping("/test2")
	public String test2() {
		log.info("確認メソッドきた2");
		return "comeTest2";
	}
}
