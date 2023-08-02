package first_spring_project.RentACar.business.abstracts;

import java.util.List;

import first_spring_project.RentACar.business.requests.CreateBrandRequest;
import first_spring_project.RentACar.business.requests.DeleteBrandRequest;
import first_spring_project.RentACar.business.requests.UpdateBrandRequest;
import first_spring_project.RentACar.business.responds.GetAllBrandsResponse;
import first_spring_project.RentACar.business.responds.GetByIdBrandResponse;

public interface BrandService {

	List<GetAllBrandsResponse> getAll();
	void add(CreateBrandRequest createBrandRequest);
//	void addModel(CreateModelRequest createModelRequest);
	void delete(DeleteBrandRequest deleteBrandRequest);
	//void deleteAllDuplicates(DeleteBrandRequest deleteBrandRequest);
	int[] getNumberOfBrandsResponse(); 
	void updateBrand(UpdateBrandRequest updateBrandRequest);
	GetByIdBrandResponse getById(int id);
	
}
