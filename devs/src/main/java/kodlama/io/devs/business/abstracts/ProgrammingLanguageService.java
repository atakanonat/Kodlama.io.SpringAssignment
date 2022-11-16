package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.programmingLanguage.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguage.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.programmingLanguage.GetAllProgrammingLanguagesResponse;
import kodlama.io.devs.business.responses.programmingLanguage.GetByIdProgrammingLanguageResponse;

public interface ProgrammingLanguageService {
	
	List<GetAllProgrammingLanguagesResponse> getAll();

	GetByIdProgrammingLanguageResponse getById(int id);
	
	void create(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);
	
	void delete(int id);
	
	void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest);
}
