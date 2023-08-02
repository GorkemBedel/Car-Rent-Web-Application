package first_spring_project.RentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import first_spring_project.RentACar.entities.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer>{
		boolean existsByName(String name); //spring jpa keywords
}
