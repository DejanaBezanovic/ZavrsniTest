package ftn.zavrsni.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import ftn.zavrsni.app.model.Takmicenje;

public interface TakmicenjeService {
	
	Page<Takmicenje> all(int pageNo);
	
	Takmicenje getOne(Long id);
		
	Takmicenje save(Takmicenje takmicenje);
		
	Takmicenje update(Takmicenje takmicenje);
		
	Takmicenje delete(Long id);
	
	Optional<Takmicenje> one(Long id);
	
	Page<Takmicenje> search(String mesto, Long formatId, int pageNum);


}
