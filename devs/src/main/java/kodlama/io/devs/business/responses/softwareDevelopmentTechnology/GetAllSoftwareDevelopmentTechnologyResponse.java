package kodlama.io.devs.business.responses.softwareDevelopmentTechnology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllSoftwareDevelopmentTechnologyResponse {
	private int id;
	private String name;
	private String programmingLanguageName;
}
