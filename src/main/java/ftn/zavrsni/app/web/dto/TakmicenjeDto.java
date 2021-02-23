package ftn.zavrsni.app.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class TakmicenjeDto {
	
	private Long id;
	
	@NotBlank
	private String naziv;
	
	@NotBlank
	 @Size(max=50)
	private String mesto;
	
	@NotBlank
	@Pattern(regexp = "^(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9])-[0-9]{4}$", message = "Datum nije validan.")
	private String datumPocetka;
	
	@NotBlank
	@Pattern(regexp = "^(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9])-[0-9]{4}$", message = "Datum nije validan.")
	private String datumZavrsetka;
	
	private Long formatId;
	private String formatTip;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getMesto() {
		return mesto;
	}
	public void setMesto(String mesto) {
		this.mesto = mesto;
	}
	public String getDatumPocetka() {
		return datumPocetka;
	}
	public void setDatumPocetka(String datumPocetka) {
		this.datumPocetka = datumPocetka;
	}
	public String getDatumZavrsetka() {
		return datumZavrsetka;
	}
	public void setDatumZavrsetka(String datumZavrsetka) {
		this.datumZavrsetka = datumZavrsetka;
	}
	public Long getFormatId() {
		return formatId;
	}
	public void setFormatId(Long formatId) {
		this.formatId = formatId;
	}
	public String getFormatTip() {
		return formatTip;
	}
	public void setFormatTip(String formatName) {
		this.formatTip = formatName;
	}
	
	
	
	
	
	

}
