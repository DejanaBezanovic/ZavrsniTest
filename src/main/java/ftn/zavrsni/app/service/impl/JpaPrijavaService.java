package ftn.zavrsni.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.zavrsni.app.model.Prijava;
import ftn.zavrsni.app.repository.PrijavaRepository;
import ftn.zavrsni.app.service.PrijavaService;

@Service
public class JpaPrijavaService implements PrijavaService{
	
	@Autowired
	private PrijavaRepository r;

	@Override
	public Prijava findOne(Long id) {
		return r.findById(id).get();
	}

	@Override
	public List<Prijava> all() {
		return r.findAll();
	}

	@Override
	public Prijava save(Prijava order) {
		return r.save(order);
	}
	
	
}
