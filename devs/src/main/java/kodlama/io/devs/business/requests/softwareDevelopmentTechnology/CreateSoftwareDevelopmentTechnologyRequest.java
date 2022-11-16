package kodlama.io.devs.business.requests.softwareDevelopmentTechnology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSoftwareDevelopmentTechnologyRequest {
	private String name;
	private int programmingLanguageId;
}
