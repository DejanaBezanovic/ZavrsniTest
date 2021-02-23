package ftn.zavrsni.app.web.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftn.zavrsni.app.model.Takmicenje;
import ftn.zavrsni.app.service.TakmicenjeService;
import ftn.zavrsni.app.support.TakmicenjeDtoToTakmicenje;
import ftn.zavrsni.app.support.TakmicenjeToTakmicenjeDto;
import ftn.zavrsni.app.web.dto.TakmicenjeDto;

@RestController
@RequestMapping(value = "/api/takmicenja")
public class ApiTakmicenjaController {
	
	@Autowired
	private TakmicenjeService ts;
	
	@Autowired
	private TakmicenjeDtoToTakmicenje toTakmicenje;
	
	@Autowired
	private TakmicenjeToTakmicenjeDto toDto;
	
	@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<TakmicenjeDto>> get(@RequestParam(value = "mesto", required = false) String mesto,
			@RequestParam(value = "formatId", required = false) Long formatId,
			@RequestParam(value = "pageNo", defaultValue = "0") int pageNo) {

		Page<Takmicenje> page = null;

		if (mesto != null || formatId != null) {
			page = ts.search(mesto, formatId, pageNo);
		} else {
			page = ts.all(pageNo);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(page.getTotalPages()));

		return new ResponseEntity<>(toDto.convert(page.getContent()), headers, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<TakmicenjeDto> getOne(@PathVariable Long id) {
		Optional<Takmicenje> tak= ts.one(id);
		if (!tak.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDto.convert(tak.get()), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<TakmicenjeDto> add(@Valid @RequestBody TakmicenjeDto newDto) {

		Takmicenje order = toTakmicenje.convert(newDto);
		Takmicenje saved = ts.save(order);

		return new ResponseEntity<>(toDto.convert(saved), HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<TakmicenjeDto> edit(@Validated @RequestBody TakmicenjeDto dto, @PathVariable Long id) {

		if (!id.equals(dto.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Takmicenje order = toTakmicenje.convert(dto);
		Takmicenje persisted = ts.save(order);

		return new ResponseEntity<>(toDto.convert(persisted), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<TakmicenjeDto> delete(@PathVariable Long id) {
		Takmicenje deleted = ts.delete(id);

		if (deleted == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDto.convert(deleted), HttpStatus.OK);
	}

	
	
	

}
