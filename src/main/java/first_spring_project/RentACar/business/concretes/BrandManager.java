package first_spring_project.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import first_spring_project.RentACar.business.abstracts.BrandService;
import first_spring_project.RentACar.business.requests.CreateBrandRequest;
import first_spring_project.RentACar.business.requests.DeleteBrandRequest;
import first_spring_project.RentACar.business.requests.UpdateBrandRequest;
import first_spring_project.RentACar.business.responds.GetAllBrandsResponse;
import first_spring_project.RentACar.business.responds.GetByIdBrandResponse;
import first_spring_project.RentACar.business.rules.BrandBusinessRules;
import first_spring_project.RentACar.core.utilities.mappers.ModelMapperService;
import first_spring_project.RentACar.dataAccess.abstracts.BrandRepository;
import first_spring_project.RentACar.dataAccess.abstracts.CarRepository;
import first_spring_project.RentACar.dataAccess.abstracts.ModelRepository;
import first_spring_project.RentACar.entities.concretes.Brand;
import first_spring_project.RentACar.entities.concretes.Car;
import first_spring_project.RentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService{
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private ModelRepository modelRepository;
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private BrandBusinessRules brandBusinessRules;
	
	@Autowired
	private ModelMapperService modelMapperService;

	
	@Autowired
	public BrandManager(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}
	
	@Override
	public List<GetAllBrandsResponse> getAll() {
			
		List<Brand> brandList = brandRepository.findAll();
//		List<GetAllBrandsResponse> brandsResponseList = new ArrayList<>();
//		
//		for(Brand br: brandList) {
//			GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
//			responseItem.setId(br.getId());
//			responseItem.setName(br.getName());
//			
//			brandsResponseList.add(responseItem);
//		}
		
		
		
		List<GetAllBrandsResponse> brandsResponseList = brandList.stream().  //mapper
				map(brand -> this.modelMapperService.forResponse()
						.map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList());
				
		
		return brandsResponseList;
	}
	
	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		
//		Brand brand = new Brand();		
//		brand.setName(createBrandRequest.getName());
		
		

		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
		
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class); //mapper
				
		this.brandRepository.save(brand);
	}

	
	@Override
	public void delete(DeleteBrandRequest deleteBrandRequest) {
		
		List<Model> modelList = modelRepository.findAll();
		
		List<Car> carList = carRepository.findAll();		
		
		List<Brand> brandList = brandRepository.findAll();
		Brand deletedBrand;
		for(Brand br : brandList) {
			if(br.getName().equals(deleteBrandRequest.getName())) {
				deletedBrand = br;
				
				for(Car car: carList) {
					if(deletedBrand.getModels().contains(car.getModel())) {
						carRepository.delete(car);
					}
				}	
				
				for(Model model : modelList) {
					if(model.getBrand() == deletedBrand) {
						modelRepository.delete(model);
					}
				}
				
				
				
								
				this.brandRepository.delete(deletedBrand);
				break;
			}
		} 
	}

	
//	@Override
//	public void deleteAllDuplicates(DeleteBrandRequest deleteBrandRequest) {
//		List<Brand> brandList = brandRepository.findAll();
//		Brand deletedBrand;
//		for(Brand br : brandList) {
//			if(br.getName().equals(deleteBrandRequest.getName())) {
//				deletedBrand = br;
//				this.brandRepository.delete(deletedBrand);
//			}
//		}
//	}

	@Override
	public int[] getNumberOfBrandsResponse() {
		List<Brand> brandList = brandRepository.findAll();
		int[] arr = new int[1];
		arr[0] = brandList.size();
		return arr;

		
		
	}

	@Override
	public void updateBrand(UpdateBrandRequest updateBrandRequest) {
		List<Brand> brandList = brandRepository.findAll();
		for(Brand br : brandList) {
			if(br.getName().equals(updateBrandRequest.getBrandName())) {
				br.setName(updateBrandRequest.newBrandName);
				this.brandRepository.save(br);
			}
		}
		
	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		
		Brand brand = brandRepository.findById(id).orElseThrow();
		GetByIdBrandResponse responseObject = this.modelMapperService.forResponse() //mapper
				.map(brand, GetByIdBrandResponse.class);
		
		//GetByIdBrandResponse responseObject = new GetByIdBrandResponse(id, brand.getName()); //brute force constructor 
		
		
		return responseObject;
	}

	

}
