package kodlama.io.devs.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import kodlama.io.devs.business.abstracts.SoftwareDevelopmentTechnologyService;
import kodlama.io.devs.business.requests.softwareDevelopmentTechnology.CreateSoftwareDevelopmentTechnologyRequest;
import kodlama.io.devs.business.requests.softwareDevelopmentTechnology.UpdateSoftwareDevelopmentTechnologyRequest;
import kodlama.io.devs.business.responses.softwareDevelopmentTechnology.GetAllSoftwareDevelopmentTechnologyResponse;
import kodlama.io.devs.business.responses.softwareDevelopmentTechnology.GetByIdSoftwareDevelopmentTechnologyResponse;

@RestController
@RequestMapping("/api/softwareDevelopmentTechnologies")
public class SoftwareDevelopmentTechnologyController {
	private SoftwareDevelopmentTechnologyService softwareDevelopmentTechnologyService;
	
	@Autowired
	public SoftwareDevelopmentTechnologyController(SoftwareDevelopmentTechnologyService softwareDevelopmentTechnologyService) {
		this.softwareDevelopmentTechnologyService = softwareDevelopmentTechnologyService;
	}
	
	@GetMapping("/")
	public List<GetAllSoftwareDevelopmentTechnologyResponse> getAll(){
		return this.softwareDevelopmentTechnologyService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdSoftwareDevelopmentTechnologyResponse getById(int id) {
		return this.softwareDevelopmentTechnologyService.getById(id);
	}
	
	@PostMapping("/")
	public void create(CreateSoftwareDevelopmentTechnologyRequest createSoftwareDevelopmentTechnologyRequest) {
		this.softwareDevelopmentTechnologyService.create(createSoftwareDevelopmentTechnologyRequest);
	}
	
	@PatchMapping("/{id}")
	public void update(@PathVariable int id, UpdateSoftwareDevelopmentTechnologyRequest updateSoftwareDevelopmentTechnologyRequest) {
		if(id != updateSoftwareDevelopmentTechnologyRequest.getId()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Request path id and software development technology id is not matched."); 
		this.softwareDevelopmentTechnologyService.update(updateSoftwareDevelopmentTechnologyRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.softwareDevelopmentTechnologyService.delete(id);
	}
}
