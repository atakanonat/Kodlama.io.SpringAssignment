package kodlama.io.devs.webApi.controllers;

import java.util.List;

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

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.devs.business.responses.GetByIdProgrammingLanguageResponse;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguageController {
	private ProgrammingLanguageService programmingLanguageService;
	
	@Autowired
	public ProgrammingLanguageController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}

	@GetMapping("/")
	public List<GetAllProgrammingLanguagesResponse> getAll(){
		return programmingLanguageService.getAll();
	}

	@GetMapping("/{id}")
	public GetByIdProgrammingLanguageResponse getById(@PathVariable int id){
		return programmingLanguageService.getById(id);
	}
	
	@PostMapping("/")
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		programmingLanguageService.create(createProgrammingLanguageRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		programmingLanguageService.delete(id);
	}
	
	@PatchMapping("/{id}")
	public void update(@PathVariable int id, UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
		if(id != updateProgrammingLanguageRequest.getId()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Request path id and programming language id is not matched.");
		}
		programmingLanguageService.update(updateProgrammingLanguageRequest);
	}
	
}
