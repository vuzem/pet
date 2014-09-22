package test.pet.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import test.pet.ejb.service.PetService;

@SuppressWarnings("serial")
@Named("petController")
@SessionScoped
public class PetController implements Serializable {

	@EJB
	PetService petService;
	
	@PostConstruct
	public void init() {
		name = petService.getName();
		System.out.println("petController initialized...");
		if ( !StringUtils.isEmpty(name) ) {
			System.out.println("Name: '" + name + "'");
		}
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
