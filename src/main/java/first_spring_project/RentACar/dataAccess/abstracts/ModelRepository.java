package first_spring_project.RentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import first_spring_project.RentACar.entities.concretes.Model;

public interface ModelRepository extends JpaRepository<Model, Integer>{
}
