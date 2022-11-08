package kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguages;

import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguages.CreateProgrammingLanguageRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProgrammingLanguagesResponse {
	private int id;
	private String name;
}
