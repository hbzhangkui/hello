package cn.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jt.feugb.EyrajaServuceFeign;

@RestController
public class HelloController {
	
	@Autowired
	private EyrajaServuceFeign eyrajaServuceFeign;
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable String name){
		
		return  eyrajaServuceFeign.hello(name);
	}
}
