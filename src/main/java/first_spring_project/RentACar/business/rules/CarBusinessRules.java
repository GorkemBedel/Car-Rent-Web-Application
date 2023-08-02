package first_spring_project.RentACar.business.rules;

import org.springframework.stereotype.Service;

import first_spring_project.RentACar.core.utilities.exceptions.BusinessException;
import first_spring_project.RentACar.dataAccess.abstracts.CarRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CarBusinessRules {
	
	private CarRepository carRepository;
	
	public void checkIfCarExist(String plate) {
		if(this.carRepository.existsByPlate(plate)){
			throw new BusinessException("This car already exist");
		}
	}

}
 