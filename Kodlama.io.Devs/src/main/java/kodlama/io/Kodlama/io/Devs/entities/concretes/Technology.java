package kodlama.io.Kodlama.io.Devs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "technology")
@Getter
@Setter
@AllArgsConstructor // parametreli constructor
@NoArgsConstructor // parametresiz constructor
@Entity // Sen bir veritabanı varlığısın demek.
public class Technology {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Id otomatik artan
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "programmingLanguageId")
	private ProgrammingLanguage programmingLanguage;
}
