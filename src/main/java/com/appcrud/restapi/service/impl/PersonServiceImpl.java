package com.appcrud.restapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.appcrud.restapi.commons.GenericServiceImpl;
import com.appcrud.restapi.dao.api.PersonRepository;
import com.appcrud.restapi.model.Person;
import com.appcrud.restapi.service.api.PersonServiceApi;

@Service
public class PersonServiceImpl extends GenericServiceImpl<Person,String> implements PersonServiceApi {

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public CrudRepository<Person, String> getDao() {
		return personRepository;
	}

}
