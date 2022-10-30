package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguagesControllers {
	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesControllers(ProgrammingLanguageService programmingLanguageService) {
		super();
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll(){
		return programmingLanguageService.getAll();
	}
	
	@GetMapping("/getbyid")
	public ProgrammingLanguage getById(int id){
		return programmingLanguageService.getById(id);
	}
	
	
	@GetMapping("/add")
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		programmingLanguageService.add(programmingLanguage);
		System.out.println("Added : " +programmingLanguage.getName());
	}
	
	@GetMapping("/update")
	public void update(ProgrammingLanguage programmingLanguage) throws Exception {
		programmingLanguageService.update(programmingLanguage);
		System.out.println("Updated : " +programmingLanguage.getName());
	}
	
	@GetMapping("/delete")
	public void delete(int id) throws Exception {
		programmingLanguageService.delete(id);
		System.out.println("Deleted");
	}
	
	
}
