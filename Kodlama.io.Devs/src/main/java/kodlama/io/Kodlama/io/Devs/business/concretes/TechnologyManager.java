package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.technologies.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technologies.DeleteTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technologies.UpdateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.technologies.GetAllTechnologiesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.technologies.GetByIdTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {

	private TechnologyRepository technologyRepository;
	private ProgrammingLanguageRepository programmingLanguageRepository;

	public TechnologyManager(TechnologyRepository technologyRepository,
			ProgrammingLanguageRepository programmingLanguageRepository) {
		super();
		this.technologyRepository = technologyRepository;
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<GetAllTechnologiesResponse> getAll() {
		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologiesResponse> technologiesResponse = new ArrayList<GetAllTechnologiesResponse>();
		for (Technology technology : technologies) {
			GetAllTechnologiesResponse responseItem = new GetAllTechnologiesResponse();
			responseItem.setProgrammingLanguageId(technology.getProgrammingLanguage().getId());
			responseItem.setProgrammingLanguageName(technology.getProgrammingLanguage().getName());
			responseItem.setId(technology.getId());
			responseItem.setName(technology.getName());
			technologiesResponse.add(responseItem);
		}
		return technologiesResponse;
	}

	@Override
	public GetByIdTechnologyResponse getById(int id) {
		Optional<Technology> technology = technologyRepository.findById(id);
		GetByIdTechnologyResponse responseItem = new GetByIdTechnologyResponse();
		responseItem.setName(technology.get().getName());
		return responseItem;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository
				.findById(createTechnologyRequest.getProgrammingLanguageId()).get();
		Technology technology = new Technology();
		technology.setProgrammingLanguage(programmingLanguage);
		technology.setName(createTechnologyRequest.getName());
		technologyRepository.save(technology);
	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository
				.findById(updateTechnologyRequest.getProgrammingLanguageId()).get();
		Technology technology = technologyRepository.findById(updateTechnologyRequest.getId()).get();
		technology.setName(updateTechnologyRequest.getName());
		technology.setProgrammingLanguage(programmingLanguage);
		technologyRepository.save(technology);
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception {
		Technology technology = technologyRepository.findById(deleteTechnologyRequest.getId()).get();
		technologyRepository.delete(technology);
	}

}
