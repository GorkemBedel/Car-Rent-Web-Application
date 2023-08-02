package first_spring_project.RentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import first_spring_project.RentACar.entities.concretes.Car;

public interface CarRepository extends JpaRepository<Car, Integer>{
	boolean existsByPlate(String plate);
}
