package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.business.requests.softwareDevelopmentTechnology.CreateSoftwareDevelopmentTechnologyRequest;
import kodlama.io.devs.business.requests.softwareDevelopmentTechnology.UpdateSoftwareDevelopmentTechnologyRequest;
import kodlama.io.devs.business.responses.softwareDevelopmentTechnology.GetAllSoftwareDevelopmentTechnologyResponse;
import kodlama.io.devs.business.responses.softwareDevelopmentTechnology.GetByIdSoftwareDevelopmentTechnologyResponse;

import java.util.List;

public interface SoftwareDevelopmentTechnologyService {
	
	List<GetAllSoftwareDevelopmentTechnologyResponse> getAll();
	
	GetByIdSoftwareDevelopmentTechnologyResponse getById(int id);
	
	void create(CreateSoftwareDevelopmentTechnologyRequest createSoftwareDevelopmentTechnologyRequest);
	
	void update(UpdateSoftwareDevelopmentTechnologyRequest updateSoftwareDevelopmentTechnologyRequest);
	
	void delete(int id);

}
