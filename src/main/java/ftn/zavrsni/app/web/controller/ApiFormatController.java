package ftn.zavrsni.app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.zavrsni.app.model.Format;
import ftn.zavrsni.app.service.FormatService;
import ftn.zavrsni.app.support.FormatToFormatDto;
import ftn.zavrsni.app.web.dto.FormatDto;

@RestController
@RequestMapping("api/formati")
public class ApiFormatController {
	
	@Autowired
	private FormatService fs;
	
	@Autowired
	private FormatToFormatDto toDto;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public ResponseEntity<List<FormatDto>> getAll(){
		
		List<Format> formati = fs.all();
		
		return new ResponseEntity<>(toDto.convert(formati), HttpStatus.OK);
	}

}
