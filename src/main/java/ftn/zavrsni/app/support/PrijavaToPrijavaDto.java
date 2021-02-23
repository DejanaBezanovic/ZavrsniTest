package ftn.zavrsni.app.support;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.zavrsni.app.model.Prijava;
import ftn.zavrsni.app.web.dto.PrijavaDto;

@Component
public class PrijavaToPrijavaDto implements Converter<Prijava, PrijavaDto>{

	@Override
	public PrijavaDto convert(Prijava p) {
		
		PrijavaDto dto = new PrijavaDto();
		
		dto.setId(p.getId());
		dto.setDrzava(p.getDrzava());
		dto.setKontakt(p.getKontakt());
		dto.setDatumPrijave(getString(p.getDatumPrijave()));
		dto.setTakmicenjeId(p.getTakmicenje().getId());
		dto.setTakmicenjeNaziv(p.getTakmicenje().getNaziv());
			
		return dto;
	}
	
	private String getString(LocalDate datum)  {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formatiran = formatter.format(datum);
        return  formatiran;
    }
	
	

}
