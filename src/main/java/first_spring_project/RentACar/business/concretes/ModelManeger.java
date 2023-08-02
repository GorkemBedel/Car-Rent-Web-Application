package first_spring_project.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import first_spring_project.RentACar.business.abstracts.ModelService;
import first_spring_project.RentACar.business.requests.CreateModelRequest;
import first_spring_project.RentACar.business.responds.GetAllModelsResponse;
import first_spring_project.RentACar.core.utilities.mappers.ModelMapperService;
import first_spring_project.RentACar.dataAccess.abstracts.ModelRepository;
import first_spring_project.RentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ModelManeger implements ModelService{

	@Autowired
	private ModelRepository modelRepository;	
	
	
	@Autowired
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllModelsResponse> getAll() {
				
		
		List<Model> models = modelRepository.findAll();
		
		
		List<GetAllModelsResponse> modelsResponse = models.stream()
				.map(model -> this.modelMapperService.forResponse()
						.map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
	
		return modelsResponse;
	}

	
	
	@Override 
	public void add(CreateModelRequest createModelRequest) {
		Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);		
		
		this.modelRepository.save(model);
		
	}

}
