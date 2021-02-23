package ftn.zavrsni.app.support;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.zavrsni.app.model.Takmicenje;
import ftn.zavrsni.app.service.FormatService;
import ftn.zavrsni.app.service.TakmicenjeService;
import ftn.zavrsni.app.web.dto.TakmicenjeDto;

@Component
public class TakmicenjeDtoToTakmicenje implements Converter<TakmicenjeDto, Takmicenje>{
	
	@Autowired
	private TakmicenjeService ts;
	
	@Autowired
	private FormatService fs;

	@Override
	public Takmicenje convert(TakmicenjeDto dto) {
		
		Takmicenje t;
		
		
		if(dto.getId() == null) {
			t = new Takmicenje();
		}else {
			t = ts.getOne(dto.getId());
		}
		
		if(t != null) {
			t.setDatumPocetka(getLocalDate(dto.getDatumPocetka()));
			t.setDatumZavrsetka(getLocalDate(dto.getDatumZavrsetka()));
			t.setFormat(fs.findOne(dto.getFormatId()));
			t.setMesto(dto.getMesto());
			t.setNaziv(dto.getNaziv());
		}

		return t;
		
	}
	
	private LocalDate getLocalDate(String datum)  {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate datumm = LocalDate.parse(datum, formatter);
        System.out.println(datumm);
        return  datumm;
    }
	
	
	

}
