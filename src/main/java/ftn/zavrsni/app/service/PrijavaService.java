package ftn.zavrsni.app.service;

import java.util.List;

import ftn.zavrsni.app.model.Prijava;


public interface PrijavaService {
	
	Prijava findOne(Long id);
	
	List<Prijava> all();
	
	Prijava save(Prijava order);

}
