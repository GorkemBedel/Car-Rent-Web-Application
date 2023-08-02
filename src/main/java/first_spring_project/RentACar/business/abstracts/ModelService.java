package first_spring_project.RentACar.business.abstracts;
import java.util.List;

import first_spring_project.RentACar.business.requests.CreateModelRequest;
import first_spring_project.RentACar.business.responds.GetAllModelsResponse;

public interface ModelService {
	
	List<GetAllModelsResponse> getAll();
	void add(CreateModelRequest createModelRequest);

}
