package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.technologies.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technologies.DeleteTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technologies.UpdateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.technologies.GetAllTechnologiesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.technologies.GetByIdTechnologyResponse;

public interface TechnologyService {
	List<GetAllTechnologiesResponse> getAll();

	GetByIdTechnologyResponse getById(int id);

	void add(CreateTechnologyRequest createTechnologyRequest) throws Exception;

	void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception;

	void delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception;
}
