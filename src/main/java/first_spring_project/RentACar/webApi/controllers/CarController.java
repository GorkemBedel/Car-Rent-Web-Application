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

import first_spring_project.RentACar.business.abstracts.CarService;
import first_spring_project.RentACar.business.requests.CreateCarRequest;
import first_spring_project.RentACar.business.responds.GetAllCarsResponse;

@RestController
@RequestMapping("/api/carController")
public class CarController {
	private CarService carService;
	
	@Autowired
	public CarController(CarService carService) {
		this.carService = carService;
	}
	
	@PostMapping("/addCar")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addCar(@RequestBody CreateCarRequest createCarRequest) {
		this.carService.add(createCarRequest);
	}
	
	@GetMapping("/getAll")
	public List<GetAllCarsResponse> getAll(){
		return this.carService.getAll();
	}
	
	

}
