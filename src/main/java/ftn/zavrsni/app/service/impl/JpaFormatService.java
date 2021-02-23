package ftn.zavrsni.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.zavrsni.app.model.Format;
import ftn.zavrsni.app.repository.FormatRepository;
import ftn.zavrsni.app.service.FormatService;

@Service
public class JpaFormatService implements FormatService{
	
	@Autowired
	private FormatRepository r;

	@Override
	public Format findOne(Long id) {

		return r.findById(id).get();
	}

	@Override
	public List<Format> all() {
		return r.findAll();
	}
	
	

}
