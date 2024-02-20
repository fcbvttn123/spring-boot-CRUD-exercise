package ca.sheridancollege.vutran.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.vutran.beans.Kid;
import ca.sheridancollege.vutran.beans.Pet;
import ca.sheridancollege.vutran.beans.PetType;
import ca.sheridancollege.vutran.repo.KidRepo;
import ca.sheridancollege.vutran.repo.PetRepo;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class AppController {
	private KidRepo kr;
	private PetRepo pr;
	
	@GetMapping("/") 
	public String indexHTML(Model model) {
		model.addAttribute("petTypes", PetType.values());
		model.addAttribute("kid", new Kid());
		model.addAttribute("pet", new Pet());
		model.addAttribute("kidList", kr.findAll());
		model.addAttribute("petList", pr.findAll());
		return "index";
	}
	
	@PostMapping("/addKid") 
	public String addKidFormSubmission(Model model, @ModelAttribute Kid kid) {
		kr.save(kid);
		
		model.addAttribute("petTypes", PetType.values());
		model.addAttribute("kid", new Kid());
		model.addAttribute("pet", new Pet());
		model.addAttribute("kidList", kr.findAll());
		model.addAttribute("petList", pr.findAll());
		return "index";
	}
	
	@PostMapping("/addPet") 
	public String addPetFormSubmission(Model model, @ModelAttribute Pet pet, @RequestParam Long kidId) {
		pr.save(pet);
		Kid k = kr.findById(kidId).get();
		k.setPet(pet);
		kr.save(k);
		
		model.addAttribute("petTypes", PetType.values());
		model.addAttribute("kid", new Kid());
		model.addAttribute("pet", new Pet());
		model.addAttribute("kidList", kr.findAll());
		model.addAttribute("petList", pr.findAll());
		return "index";
	}
}
