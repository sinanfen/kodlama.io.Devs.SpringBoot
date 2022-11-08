package kodlama.io.Kodlama.io.Devs.business.responses.technologies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTechnologiesResponse {
	private int id;
	private String name;
	private int programmingLanguageId;
	private String programmingLanguageName;
}
