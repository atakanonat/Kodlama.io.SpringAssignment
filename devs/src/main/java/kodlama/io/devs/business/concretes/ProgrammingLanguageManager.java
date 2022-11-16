package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.requests.programmingLanguage.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguage.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.programmingLanguage.GetAllProgrammingLanguagesResponse;
import kodlama.io.devs.business.responses.programmingLanguage.GetByIdProgrammingLanguageResponse;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{
	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		List<ProgrammingLanguage> dbLanguages = this.programmingLanguageRepository.findAll();
		List<GetAllProgrammingLanguagesResponse> result = new ArrayList<GetAllProgrammingLanguagesResponse>();
		for(ProgrammingLanguage programmingLanguage : dbLanguages) {
			GetAllProgrammingLanguagesResponse getAllProgrammingLanguagesResponse = new GetAllProgrammingLanguagesResponse();
			getAllProgrammingLanguagesResponse.setId(programmingLanguage.id());
			getAllProgrammingLanguagesResponse.setName(programmingLanguage.name());
			result.add(getAllProgrammingLanguagesResponse);
		}
		return result;
	}
	
	@Override
	public GetByIdProgrammingLanguageResponse getById(int id) {
		ProgrammingLanguage dbLanguage = this.programmingLanguageRepository.findById(id).orElse(new ProgrammingLanguage());
		GetByIdProgrammingLanguageResponse result = new GetByIdProgrammingLanguageResponse();
		result.setId(dbLanguage.id());
		result.setName(dbLanguage.name());
		return result;
	}

	@Override
	public void create(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		ProgrammingLanguage addedLanguage = new ProgrammingLanguage();
		addedLanguage.name(createProgrammingLanguageRequest.getName());
		programmingLanguageRepository.save(addedLanguage);
	}

	@Override
	public void delete(int id) {
		programmingLanguageRepository.deleteById(id);
	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository
														.findById(updateProgrammingLanguageRequest.getId())
														.orElse(new ProgrammingLanguage());
		programmingLanguage.name(updateProgrammingLanguageRequest.getName());
		programmingLanguageRepository.save(programmingLanguage);
	}
	
}
