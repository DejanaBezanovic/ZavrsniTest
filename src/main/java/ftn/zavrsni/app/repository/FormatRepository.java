package ftn.zavrsni.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.zavrsni.app.model.Format;

@Repository
public interface FormatRepository extends JpaRepository<Format, Long> {

}
