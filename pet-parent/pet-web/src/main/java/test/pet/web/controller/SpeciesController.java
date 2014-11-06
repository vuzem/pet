package test.pet.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("speciesController")
@SessionScoped
@SuppressWarnings("serial")
public class SpeciesController implements Serializable {

	private List<String> species = null;
	
	@PostConstruct
	public void init() {
		species = new ArrayList<String>();
		species.add("Cat");
		species.add("Dog");
		species.add("Bird");
		System.out.println("SpeciesController initialized...");
	}

	public List<String> getSpecies() {
		return species;
	}
	
}
