package kodlama.io.Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository // Bu sınıf bir DataAccess nesnesidir.
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {

	List<ProgrammingLanguage> programmingLanguages;

	public InMemoryProgrammingLanguageRepository() {
		programmingLanguages = new ArrayList<ProgrammingLanguage>();
		programmingLanguages.add(new ProgrammingLanguage(1, "Java"));
		programmingLanguages.add(new ProgrammingLanguage(2, "C#"));
		programmingLanguages.add(new ProgrammingLanguage(3, "Python"));
		programmingLanguages.add(new ProgrammingLanguage(4, "C++"));
		programmingLanguages.add(new ProgrammingLanguage(5, "JavaScript"));
		programmingLanguages.add(new ProgrammingLanguage(6, "Kotlin"));
		programmingLanguages.add(new ProgrammingLanguage(7, "Swift"));
		programmingLanguages.add(new ProgrammingLanguage(8, "Flutter"));
		programmingLanguages.add(new ProgrammingLanguage(9, "Dart"));
		programmingLanguages.add(new ProgrammingLanguage(10, "Pearl"));
		programmingLanguages.add(new ProgrammingLanguage(11, "GoLang"));
		programmingLanguages.add(new ProgrammingLanguage(12, "VSBasic"));
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		// TODO Auto-generated method stub
		return programmingLanguages;
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		ProgrammingLanguage programmingLanguageId = null;
		for (ProgrammingLanguage language : programmingLanguages) {
			if (language.getId() == id)
				programmingLanguageId = language;
		}
		if (programmingLanguageId != null)
			return programmingLanguageId;
		throw null;
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		int lastId = programmingLanguages.get(programmingLanguages.size() - 1).getId();
		programmingLanguage.setId(lastId + 1);
		programmingLanguages.add(programmingLanguage);
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		for (ProgrammingLanguage lang : programmingLanguages) {
			if (lang.getId() == programmingLanguage.getId()) {
				lang.setName(programmingLanguage.getName());
				break;
			}
		}
	}

	@Override
	public void delete(int id) {
		ProgrammingLanguage toDelete = getById(id);
		if (toDelete != null) {
			programmingLanguages.remove(toDelete);
			return;
		}
		throw null;

	}

}
