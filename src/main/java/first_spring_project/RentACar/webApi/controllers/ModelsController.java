package first_spring_project.RentACar.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import first_spring_project.RentACar.business.abstracts.ModelService;
import first_spring_project.RentACar.business.requests.CreateModelRequest;
import first_spring_project.RentACar.business.responds.GetAllModelsResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api/models")
@RestController
public class ModelsController {
	
	@Autowired
	private ModelService modelService;
	
	@GetMapping()
	public List<GetAllModelsResponse> getAll(){
		return modelService.getAll();
	}
	
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() CreateModelRequest createModelRequest) {
		this.modelService.add(createModelRequest);	
	}
	
}
