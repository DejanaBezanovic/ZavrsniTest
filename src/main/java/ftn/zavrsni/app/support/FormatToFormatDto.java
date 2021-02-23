package ftn.zavrsni.app.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.zavrsni.app.model.Format;
import ftn.zavrsni.app.web.dto.FormatDto;

@Component
public class FormatToFormatDto implements Converter<Format, FormatDto>{

	@Override
	public FormatDto convert(Format f) {
		
		FormatDto dto = new FormatDto();
		dto.setId(f.getId());
		dto.setTip(f.getTip());
		dto.setBroj(f.getBroj());
		
		return dto;
	}
	
	public List<FormatDto> convert(List<Format> source){
		List<FormatDto> retVal = new ArrayList<>();
		
		for(Format s : source) {
			FormatDto dto = convert(s);
			retVal.add(dto);
		}
		
		return retVal;
	}


}
