package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.technologies.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technologies.DeleteTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technologies.UpdateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.technologies.GetAllTechnologiesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.technologies.GetByIdTechnologyResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {
	private TechnologyService technologyService;

	public TechnologiesController(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}

	@GetMapping("/getall")
	public List<GetAllTechnologiesResponse> getAll() {
		return technologyService.getAll();
	}

	@GetMapping("/getbyid")
	public GetByIdTechnologyResponse getById(int id) {
		return technologyService.getById(id);
	}

	@PostMapping("/add")
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
		this.technologyService.add(createTechnologyRequest);
	}

	@PostMapping("/update")
	public void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
		this.technologyService.update(updateTechnologyRequest);
	}

	@PostMapping("/delete")
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception {
		this.technologyService.delete(deleteTechnologyRequest);
	}
}
