package first_spring_project.RentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
	
	
	@NotNull
	@NotBlank
	@Size(min =  8, max = 10)
	private String plate;
	
	
	private double dailyPrice;
	
	private int modelYear;
	
	private int state;
	
	private int modelId;
	
	

}
