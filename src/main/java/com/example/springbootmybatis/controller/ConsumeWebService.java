package com.example.springbootmybatis.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.springbootmybatis.model.User;


@RestController
@RequestMapping("/ws")
public class ConsumeWebService {
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value="/getUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getUsers(@RequestParam(name="page", required=false)Integer page) {
		System.out.println(page);
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<String> entity = new HttpEntity<String>(headers);
	    return restTemplate.exchange(
	       "https://reqres.in/api/users?page="+page, HttpMethod.GET, entity, String.class).getBody();
	}
	
	@PostMapping(value = "/createUser", produces = MediaType.APPLICATION_JSON_VALUE)
	   public String createUser(@RequestBody User user) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<User> entity = new HttpEntity<User>(user,headers);
	      
	      return restTemplate.exchange(
	         "https://reqres.in/api/users", HttpMethod.POST, entity, String.class).getBody();
	   }
}
