package first_spring_project.RentACar.business.responds;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarsResponse {
	
	private int id;
	private String plate;
	private double dailyPrice;
	private int modelYear;
	private int state; // 1-available 2-rented 3-maintenance
	private String modelName;
	private String brandName;

}
