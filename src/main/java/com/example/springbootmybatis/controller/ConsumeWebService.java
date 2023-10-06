package com.example.springbootmybatis.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.springbootmybatis.model.Utente;
import com.example.springbootmybatis.soapclient.MySOAPClient;



@RestController
@RequestMapping("/ws")
public class ConsumeWebService {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private MySOAPClient mySOAPClient;
	
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
	   public String createUser(@RequestBody Utente user) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Utente> entity = new HttpEntity<Utente>(user,headers);
	      
	      return restTemplate.exchange(
	         "https://reqres.in/api/users", HttpMethod.POST, entity, String.class).getBody();
	   }
	@GetMapping(value="/addizione/{a}/{b}")
	public int addizione(@PathVariable("a") int a, @PathVariable("b")int b) {
		return mySOAPClient.addizione(a, b).getReturn();
	}
}
