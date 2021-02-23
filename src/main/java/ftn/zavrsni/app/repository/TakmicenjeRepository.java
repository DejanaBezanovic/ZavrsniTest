package ftn.zavrsni.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ftn.zavrsni.app.model.Takmicenje;

@Repository
public interface TakmicenjeRepository extends JpaRepository<Takmicenje, Long> {

	@Query("SELECT o FROM Takmicenje o WHERE" +
			"(:mesto = NULL OR o.mesto LIKE :mesto) AND " + 
			"(:formatId = NULL OR o.format.id = :formatId)")
	Page<Takmicenje> search(@Param("mesto") String mesto, @Param("formatId") Long formatId, Pageable pageable);

}
