package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service 
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		super();
		this.programmingLanguageRepository = programmingLanguageRepository;
	}



	@Override
	public List<ProgrammingLanguage> getAll() {
		// TODO Auto-generated method stub
		return programmingLanguageRepository.getAll();
	}



	@Override
	public ProgrammingLanguage getById(int id) {
		// TODO Auto-generated method stub
		return programmingLanguageRepository.getById(id);
	}



	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		IsProgrammingLanguageNameEmpty(programmingLanguage);
		programmingLanguageRepository.add(programmingLanguage);
		
	}



	@Override
	public void update(ProgrammingLanguage programmingLanguage) throws Exception {
		IsProgrammingLanguageNameEmpty(programmingLanguage);
		programmingLanguageRepository.update(programmingLanguage);		
	}



	@Override
	public void delete(int id) {
		programmingLanguageRepository.delete(id);		
	}
	
	private void IsProgrammingLanguageNameEmpty(ProgrammingLanguage programmingLanguage) throws Exception {
		if(programmingLanguage.getName() == "")
			throw new Exception("Programming language name field must not empty.");
		
		var programmingLanguages = programmingLanguageRepository.getAll();
		
		for (ProgrammingLanguage languages : programmingLanguages) {
			if (languages.getName().equals(programmingLanguage.getName())){
				throw new Exception("This programming language is already exist.");
			}
		}
	}

}
