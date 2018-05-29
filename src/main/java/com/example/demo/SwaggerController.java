package com.example.demo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/foos")
@Api(value="My SwaggerController apis", description="api descritpion")
public class SwaggerController {

	@ApiOperation(value="sayHi method",httpMethod="GET",notes="be careful")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Successfuly executed"),
			@ApiResponse(code=400, message="400 returned"),
			@ApiResponse(code=401, message="401 returned"),
			@ApiResponse(code=402, message="402 returned")
	})
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String sayHi() {
		return "hi";
	}
	List<User> users=new ArrayList<User>();
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public List<User> getUsers(){
		return users;
	}
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public User getUser(@PathVariable("id") int id) {
		return users.get(id);
	}
	
	@RequestMapping(value="/user/add", method=RequestMethod.POST)
	public User saveUser(@RequestBody User user) {
		this.users.add(user);
		return this.users.get(users.size()-1);
	}
}

class User{
	@ApiModelProperty(dataType="int", notes="This is the id of the user")
	int id;
	@ApiModelProperty(dataType="string", notes="This is the name of the user")
	String name;
	
	public User() {
		super();
	}
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
