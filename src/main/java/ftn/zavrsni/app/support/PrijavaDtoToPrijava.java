package ftn.zavrsni.app.support;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.zavrsni.app.model.Prijava;
import ftn.zavrsni.app.service.PrijavaService;
import ftn.zavrsni.app.service.TakmicenjeService;
import ftn.zavrsni.app.web.dto.PrijavaDto;

@Component
public class PrijavaDtoToPrijava implements Converter<PrijavaDto, Prijava>{
	
	@Autowired
	private PrijavaService ps;
	
	@Autowired
	private TakmicenjeService ts;
	
	@Override
	public Prijava convert(PrijavaDto dto) {
		Prijava p;
		
		
		if(dto.getId() == null) {
			p = new Prijava();
		}else {
			p = ps.findOne(dto.getId());
		}
		
		if(p != null) {
			p.setDrzava(dto.getDrzava());
			p.setKontakt(dto.getKontakt());
			p.setDatumPrijave(LocalDate.now());
			p.setTakmicenje(ts.getOne(dto.getTakmicenjeId()));
			
			
		}
		
		
		return p;
	}
	

}
