package ftn.zavrsni.app.support;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.zavrsni.app.model.Takmicenje;
import ftn.zavrsni.app.web.dto.TakmicenjeDto;

@Component
public class TakmicenjeToTakmicenjeDto implements Converter<Takmicenje, TakmicenjeDto> {

	@Override
	public TakmicenjeDto convert(Takmicenje t) {
		
		TakmicenjeDto dto = new TakmicenjeDto();
		
		dto.setId(t.getId());
		dto.setDatumPocetka(getString(t.getDatumPocetka()));
		dto.setDatumZavrsetka(getString(t.getDatumZavrsetka()));
		dto.setMesto(t.getMesto());
		dto.setNaziv(t.getNaziv());
		dto.setFormatId(t.getFormat().getId());
		dto.setFormatTip(t.getFormat().getTip());
		return dto;
	}
	
	public List<TakmicenjeDto> convert(List<Takmicenje> source){
		List<TakmicenjeDto> ret = new ArrayList<>();
		
		for(Takmicenje z : source){
			ret.add(convert(z));
		}
		
		return ret;
	}
	
	
	private String getString(LocalDate datum)  {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formatiran = formatter.format(datum);
        return  formatiran;
    }

	
}
