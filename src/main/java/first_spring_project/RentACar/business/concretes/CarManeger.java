package first_spring_project.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import first_spring_project.RentACar.business.abstracts.CarService;
import first_spring_project.RentACar.business.requests.CreateCarRequest;
import first_spring_project.RentACar.business.responds.GetAllCarsResponse;
import first_spring_project.RentACar.business.responds.GetAllModelsResponse;
import first_spring_project.RentACar.business.rules.CarBusinessRules;
import first_spring_project.RentACar.core.utilities.mappers.ModelMapperService;
import first_spring_project.RentACar.dataAccess.abstracts.CarRepository;
import first_spring_project.RentACar.entities.concretes.Car;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarManeger implements CarService{
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired 
	private CarBusinessRules carBusinessRules;
	
	@Autowired
	private ModelMapperService modelMapperService;
	
	@Autowired
	public CarManeger(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@Override
	public void add(CreateCarRequest createCarRequest) {

		this.carBusinessRules.checkIfCarExist(createCarRequest.getPlate());
		
		Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);
		
		this.carRepository.save(car);
	}

	@Override
	public List<GetAllCarsResponse> getAll() {
		
		List<Car> carList = this.carRepository.findAll();
		
		List<GetAllCarsResponse> carsResponse = carList.stream()
				.map(car ->  this.modelMapperService.forResponse()
					.map(car, GetAllCarsResponse.class)).collect(Collectors.toList());
		
		return carsResponse;
		
	}

}
