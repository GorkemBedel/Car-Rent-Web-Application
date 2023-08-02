//package first_spring_project.RentACar.dataAccess.concretes;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
//
//import first_spring_project.RentACar.dataAccess.abstracts.BrandRepository;
//import first_spring_project.RentACar.entities.concretes.Brand;
//@Repository 
//public class InMemoryBrandRepository implements BrandRepository{
//	
//	
//	List<Brand> brands;
//	
//	
//
//	public InMemoryBrandRepository() {
//		brands = new ArrayList<>();
//		brands.add(new Brand("BMW",1));	
//		
//	}
//
//
//
//	@Override
//	public List<Brand> getAll() {
//		return brands;
//	}
//
//
//
//
//}
