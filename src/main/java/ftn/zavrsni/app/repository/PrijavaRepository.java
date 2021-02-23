package ftn.zavrsni.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.zavrsni.app.model.Prijava;

@Repository
public interface PrijavaRepository extends JpaRepository<Prijava, Long>{

}
