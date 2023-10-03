package com.example.springbootmybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.springbootmybatis.model.Customer;

@Mapper
public interface CustomerMapper {
	@Select("select * from customer;")
	public List<Customer> getAllCustomers();
}
