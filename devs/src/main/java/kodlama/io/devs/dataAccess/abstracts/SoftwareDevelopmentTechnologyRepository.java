package kodlama.io.devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.devs.entities.concretes.SoftwareDevelopmentTechnology;

public interface SoftwareDevelopmentTechnologyRepository extends JpaRepository<SoftwareDevelopmentTechnology, Integer> {

}
