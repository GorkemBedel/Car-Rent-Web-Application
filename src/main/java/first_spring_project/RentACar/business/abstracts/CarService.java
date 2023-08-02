package first_spring_project.RentACar.business.abstracts;

import java.util.List;

import first_spring_project.RentACar.business.requests.CreateCarRequest;
import first_spring_project.RentACar.business.responds.GetAllCarsResponse;

public interface CarService {
	
	void add(CreateCarRequest createCarRequest);
	List<GetAllCarsResponse> getAll();

}
