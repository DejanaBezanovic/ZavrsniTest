package ftn.zavrsni.app.service;

import java.util.List;

import ftn.zavrsni.app.model.Format;

public interface FormatService {
	
	Format findOne(Long id);
	
	List<Format> all();

}
