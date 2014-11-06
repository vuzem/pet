package test.pet.web.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.ProjectStage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import test.pet.ejb.service.PetService;

@Named("petController")
@SessionScoped
@SuppressWarnings("serial")
public class PetController implements Serializable {

	@EJB
	PetService petService;
	
	@Inject
	SpeciesController speciesController;
	
	@PostConstruct
	public void init() {
		name = petService.getName();
		System.out.println("petController initialized...");
		if ( !StringUtils.isEmpty(name) ) {
			System.out.println("Name: '" + name + "'");
		}
		ProjectStage projectStage = FacesContext.getCurrentInstance().getApplication().getProjectStage();
		System.out.println(projectStage);
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String actionDest() {
		System.out.println("going to dest...");
		FacesMessage facesMessage = new FacesMessage("dest");
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		return "dest";
	}

	public String actionCreate() {
		System.out.println("create pet...");
		List<String> species = speciesController.getSpecies();
		String[] array = species.toArray(new String[species.size()]);
		System.out.println("Available species: " + Arrays.toString(array));
		return "listPets";
	}

}
