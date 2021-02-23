package ftn.zavrsni.app.web.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PrijavaDto {
	
	private Long id;
	
	@Size(max=3, min=3)
	private String drzava;
	
    private String kontakt;
    
    @Pattern(regexp = "^(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9])-[0-9]{4}$", message = "Datum nije validan.")
    private String datumPrijave;
    
    private Long takmicenjeId;
    
    private String takmicenjeNaziv;
    
    private String prijavljen;

	public PrijavaDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	public String getPrijavljen() {
		return prijavljen;
	}

	public void setPrijavljen(String prijavljen) {
		this.prijavljen = prijavljen;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getKontakt() {
		return kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}

	public String getDatumPrijave() {
		return datumPrijave;
	}

	public void setDatumPrijave(String datumPrijave) {
		this.datumPrijave = datumPrijave;
	}

	public Long getTakmicenjeId() {
		return takmicenjeId;
	}

	public void setTakmicenjeId(Long takmicenjeId) {
		this.takmicenjeId = takmicenjeId;
	}

	public String getTakmicenjeNaziv() {
		return takmicenjeNaziv;
	}

	public void setTakmicenjeNaziv(String takmicenjeNaziv) {
		this.takmicenjeNaziv = takmicenjeNaziv;
	}
    
    

}
