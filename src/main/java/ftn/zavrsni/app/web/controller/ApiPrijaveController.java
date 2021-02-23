package ftn.zavrsni.app.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.zavrsni.app.model.Prijava;
import ftn.zavrsni.app.model.Takmicenje;
import ftn.zavrsni.app.service.PrijavaService;
import ftn.zavrsni.app.service.TakmicenjeService;
import ftn.zavrsni.app.support.PrijavaDtoToPrijava;
import ftn.zavrsni.app.support.PrijavaToPrijavaDto;
import ftn.zavrsni.app.web.dto.PrijavaDto;



@RestController
@RequestMapping(value = "/api/prijave")
public class ApiPrijaveController {
	
	@Autowired
	private PrijavaDtoToPrijava toPrijava;
	
	@Autowired
	private PrijavaToPrijavaDto toDto;
	
	@Autowired
	private TakmicenjeService ts;
	
	@Autowired
	private PrijavaService ps;
	
	
	@PreAuthorize("hasRole('KORISNIK')")
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<PrijavaDto> add(@Valid @RequestBody PrijavaDto newDto) {
			
		Prijava prijava = toPrijava.convert(newDto);
		Takmicenje t = ts.getOne(prijava.getTakmicenje().getId());
	 if(t.getFormat().getBroj() > 0) {
		int kapacitet = t.getFormat().getBroj() - 1;
		t.getFormat().setBroj(kapacitet);
		Prijava saved = ps.save(prijava);
	    return new ResponseEntity<>(toDto.convert(saved), HttpStatus.CREATED);
	}else {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
		
	}

}
