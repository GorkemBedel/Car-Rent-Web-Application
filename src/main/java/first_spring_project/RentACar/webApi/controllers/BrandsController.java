package first_spring_project.RentACar.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import first_spring_project.RentACar.business.abstracts.BrandService;
import first_spring_project.RentACar.business.requests.CreateBrandRequest;
import first_spring_project.RentACar.business.requests.DeleteBrandRequest;
import first_spring_project.RentACar.business.requests.UpdateBrandRequest;
import first_spring_project.RentACar.business.responds.GetAllBrandsResponse;
import first_spring_project.RentACar.business.responds.GetByIdBrandResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/controller")
public class BrandsController {
	private BrandService brandService;
	
	@Autowired
	public BrandsController(BrandService brandService) {
		this.brandService = brandService;
	}
	
	@GetMapping("/getAll")
	public List<GetAllBrandsResponse> getAll(){
		return brandService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdBrandResponse getById(@PathVariable("id") int id) {
		return brandService.getById(id);
	}
	
	@PostMapping("/addBrand")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid() CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);
	}
	
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody DeleteBrandRequest deleteBrandRequest) {
		this.brandService.delete(deleteBrandRequest);
	}
	
//	@DeleteMapping("/deleteDuplicates")
//	public void deleteDuplicates(DeleteBrandRequest deleteBrandRequest) {
//		this.brandService.deleteAllDuplicates(deleteBrandRequest);
//	}
	
	@GetMapping("/getNumberOfBrands")
	public int[] getNumberOfBrandsResponse() {
		return this.brandService.getNumberOfBrandsResponse();
	}
	
	@PutExchange("/UpdateBrand")
	public void updateBrandResponse(@RequestBody UpdateBrandRequest updateBrandResponse) {
		this.brandService.updateBrand(updateBrandResponse);
	}
	
	
	
	
	
	
	
	
	

}
