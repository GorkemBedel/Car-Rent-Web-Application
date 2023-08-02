package first_spring_project.RentACar.business.responds;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdBrandResponse {
	private int id;
	private String name;
	
}
