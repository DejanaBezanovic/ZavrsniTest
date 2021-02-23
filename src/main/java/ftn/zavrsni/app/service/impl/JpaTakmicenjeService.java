package ftn.zavrsni.app.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ftn.zavrsni.app.model.Takmicenje;
import ftn.zavrsni.app.repository.TakmicenjeRepository;
import ftn.zavrsni.app.service.TakmicenjeService;

@Service
public class JpaTakmicenjeService implements TakmicenjeService{
	
	@Autowired
	private TakmicenjeRepository r;

	@Override
	public Page<Takmicenje> all(int pageNo) {
		return r.findAll(PageRequest.of(pageNo, 2));
	}

	@Override
	public Takmicenje getOne(Long id) {
		return r.findById(id).get();
	}

	@Override
	public Takmicenje save(Takmicenje takmicenje) {
		return r.save(takmicenje);
	}

	@Override
	public Takmicenje update(Takmicenje takmicenje) {
		return r.save(takmicenje);
	}

	@Override
	public Takmicenje delete(Long id) {
		Optional<Takmicenje> op = r.findById(id);
		if(op.isPresent()) {
			r.deleteById(id);
			return op.get();
		}
		return null;
	}

	@Override
	public Page<Takmicenje> search(String mesto, Long formatId, int pageNum) {
		
		if(mesto != null) {
			mesto = "%" + mesto + "%";
		}
		
		return r.search(mesto, formatId, PageRequest.of(pageNum, 2));
	}

	@Override
	public Optional<Takmicenje> one(Long id) {
		return r.findById(id);
	}

	
	
	
	

}
