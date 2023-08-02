package first_spring_project.RentACar.business.rules;

import org.springframework.stereotype.Service;

import first_spring_project.RentACar.core.utilities.exceptions.BusinessException;
import first_spring_project.RentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
	
	private BrandRepository brandRepository;
	
	public void checkIfBrandNameExists(String name) {
		if(this.brandRepository.existsByName(name)) {
			throw new BusinessException("That brand already exist");
		}
	}
}
