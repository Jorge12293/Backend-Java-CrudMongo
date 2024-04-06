package com.appcrud.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appcrud.restapi.model.Person;
import com.appcrud.restapi.service.api.PersonServiceApi;

@RestController
@RequestMapping(value = "/api/v1")
@CrossOrigin("*")
public class PersonController {

	@Autowired
	private PersonServiceApi personServiceApi;
	
	@GetMapping(value= "/all")
	public List<Person> getAll(){
		return personServiceApi.getAll();
	}
	
	@GetMapping(value= "/find/{id}")
	public Person find(@PathVariable String id) {
		return personServiceApi.get(id);	
	}
	
	@PostMapping(value="/save")
	public ResponseEntity<Person> save(@RequestBody Person person){
		Person obj = personServiceApi.save(person);
		return new ResponseEntity<Person>(obj,HttpStatus.OK);
	}
	
	@GetMapping(value= "/delete/{id}")
	public ResponseEntity<Person> delete(@PathVariable String id){
		Person person = personServiceApi.get(id);
		if(person != null) {
			personServiceApi.delete(id);
		}else {
			return new ResponseEntity<Person>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Person>(person,HttpStatus.OK);
	}
	
}
