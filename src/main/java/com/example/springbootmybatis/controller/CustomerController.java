package com.example.springbootmybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootmybatis.mapper.CustomerMapper;
import com.example.springbootmybatis.model.Customer;


@RestController
@RequestMapping("/rest")
public class CustomerController {

	@Autowired
	private CustomerMapper customerMapper;
	
	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers(){
		List<Customer> allCustomers=customerMapper.getAllCustomers();
		System.out.println(allCustomers.get(0));
		return allCustomers;
	}
}
