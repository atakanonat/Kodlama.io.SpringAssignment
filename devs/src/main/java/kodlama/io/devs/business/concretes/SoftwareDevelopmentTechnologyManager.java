package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import kodlama.io.devs.business.abstracts.SoftwareDevelopmentTechnologyService;
import kodlama.io.devs.business.requests.softwareDevelopmentTechnology.CreateSoftwareDevelopmentTechnologyRequest;
import kodlama.io.devs.business.requests.softwareDevelopmentTechnology.UpdateSoftwareDevelopmentTechnologyRequest;
import kodlama.io.devs.business.responses.softwareDevelopmentTechnology.GetAllSoftwareDevelopmentTechnologyResponse;
import kodlama.io.devs.business.responses.softwareDevelopmentTechnology.GetByIdSoftwareDevelopmentTechnologyResponse;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.dataAccess.abstracts.SoftwareDevelopmentTechnologyRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.devs.entities.concretes.SoftwareDevelopmentTechnology;

@Service
public class SoftwareDevelopmentTechnologyManager implements SoftwareDevelopmentTechnologyService{
	
	private SoftwareDevelopmentTechnologyRepository softwareDevelopmentTechnologyRepository;
	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	@Autowired
	public SoftwareDevelopmentTechnologyManager(SoftwareDevelopmentTechnologyRepository softwareDevelopmentTechnologyRepository, 
			ProgrammingLanguageRepository programmingLanguageRepository) {
		this.softwareDevelopmentTechnologyRepository = softwareDevelopmentTechnologyRepository;
		this.programmingLanguageRepository = programmingLanguageRepository;
	}
	
	@Override
	public List<GetAllSoftwareDevelopmentTechnologyResponse> getAll() {
		List<GetAllSoftwareDevelopmentTechnologyResponse> result = new ArrayList<GetAllSoftwareDevelopmentTechnologyResponse>();
		for(SoftwareDevelopmentTechnology technology : this.softwareDevelopmentTechnologyRepository.findAll()) {
			GetAllSoftwareDevelopmentTechnologyResponse techToBeMapped = new GetAllSoftwareDevelopmentTechnologyResponse();
			techToBeMapped.setId(technology.id());
			techToBeMapped.setName(technology.name());
			techToBeMapped.setProgrammingLanguageName(technology.programmingLanguage().name());
			result.add(techToBeMapped);
		}
		return result;
	}

	@Override
	public void create(CreateSoftwareDevelopmentTechnologyRequest createSoftwareDevelopmentTechnologyRequest) {
		SoftwareDevelopmentTechnology addedTech = new SoftwareDevelopmentTechnology();
		addedTech.name(createSoftwareDevelopmentTechnologyRequest.getName());
		var programmingLanguage = this.programmingLanguageRepository.findById(createSoftwareDevelopmentTechnologyRequest.getProgrammingLanguageId()).orElse(new ProgrammingLanguage());
		if(programmingLanguage.id() == 0) throw new NotFoundException("Programming Language does not exists");
		addedTech.programmingLanguage(programmingLanguage);
		this.softwareDevelopmentTechnologyRepository.save(addedTech);
	}

	@Override
	public GetByIdSoftwareDevelopmentTechnologyResponse getById(int id) {
		SoftwareDevelopmentTechnology dbTech = this.softwareDevelopmentTechnologyRepository.findById(id).orElse(new SoftwareDevelopmentTechnology());
		if(dbTech.id() == 0) throw new NotFoundException("Software development technology does not exists");
		GetByIdSoftwareDevelopmentTechnologyResponse result = new GetByIdSoftwareDevelopmentTechnologyResponse();
		result.setId(dbTech.id());
		result.setName(dbTech.name());
		result.setProgrammingLanguageName(dbTech.programmingLanguage().name());
		return result;
	}

	@Override
	public void update(UpdateSoftwareDevelopmentTechnologyRequest updateSoftwareDevelopmentTechnologyRequest) {
		SoftwareDevelopmentTechnology toBeUpdated = this.softwareDevelopmentTechnologyRepository.findById(updateSoftwareDevelopmentTechnologyRequest.getId()).orElse(new SoftwareDevelopmentTechnology());
		if(toBeUpdated.id() == 0) throw new NotFoundException("Software development technology does not exists");
		toBeUpdated.name(updateSoftwareDevelopmentTechnologyRequest.getName());
		ProgrammingLanguage programmingLanguage = this.programmingLanguageRepository.findById(updateSoftwareDevelopmentTechnologyRequest.getProgrammingLanguageId()).orElse(new ProgrammingLanguage());
		if(programmingLanguage.id() == 0) throw new NotFoundException("Programming language does not exists");
		toBeUpdated.programmingLanguage(programmingLanguage);
		this.softwareDevelopmentTechnologyRepository.save(toBeUpdated);
	}

	@Override
	public void delete(int id) {
		this.softwareDevelopmentTechnologyRepository.deleteById(id);
	}
}
