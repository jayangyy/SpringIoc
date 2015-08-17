package com.domain.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
@Service
public class PersonService {
	public void AddPerson(String personName) {
		System.out.print("add person" + personName);
	}
	public Boolean deletePerson(String personName) {	
			return false;				
	}
	public String editPerson(String personName)  {
		System.out.println("edit person " + personName);
		while(1==1){
			//Å×³öÒì³£
			return editPerson(personName);
		}
		//throw new RuntimeException("edit person throw exception");
	}
}
