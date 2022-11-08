package kodlama.io.Kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

															//(Integer)PrimaryKey Int olacağı için ekledik
public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage,Integer>{ 
	//Concrete yok çünkü Jpa generic bir yapıda çalışıyor ve ilgili nesne için Bellekte onu implemente etmiş gibi
	//class türetiyor. Yani concrete bellekte üretiliyor.
	
	
//	List<ProgrammingLanguage> getAll();
//	ProgrammingLanguage getById(int id);
//	void add(ProgrammingLanguage programmingLanguage);
//	void update(ProgrammingLanguage programmingLanguage);
//	void delete(int id);
}
