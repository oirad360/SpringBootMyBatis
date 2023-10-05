package com.example.springbootmybatis.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.springbootmybatis.mapper.CustomerMapper;
import com.example.springbootmybatis.model.Customer;


@RestController
@RequestMapping("/rest")
public class CustomerController {

	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers(){
		List<Customer> allCustomers=customerMapper.getAllCustomers();
		System.out.println(allCustomers.get(0));
		return allCustomers;
	}
	
	@GetMapping(value="/getUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getUsers() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<String> entity = new HttpEntity<String>(headers);
	    return restTemplate.exchange(
	       "https://reqres.in/api/users", HttpMethod.GET, entity, String.class).getBody();
	}
}
