package cn.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cn.jt.feugb.EyrajaServuceFeign;
import cn.jt.feugb.SidecarService;

@RestController
public class HelloController {
	
	@Autowired
	private EyrajaServuceFeign eyrajaServuceFeign;
	@Autowired
	private SidecarService sidecarService;
	@RequestMapping("/hello/{name}")
	@HystrixCommand(fallbackMethod="helloFallBack")
	public String hello(@PathVariable String name){
		
		return  eyrajaServuceFeign.hello(name);
	}
	
	public String helloFallBack(String name){
		
		return "tom";
	}
	@RequestMapping("/")
	public String node(){
		
		return sidecarService.node();
	}
}
