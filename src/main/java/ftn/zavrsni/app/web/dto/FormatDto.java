package ftn.zavrsni.app.web.dto;

import javax.validation.constraints.NotBlank;

public class FormatDto {
	
	private Long id;
	
	@NotBlank
	private String tip;
	
	private int broj;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public int getBroj() {
		return broj;
	}

	public void setBroj(int broj) {
		this.broj = broj;
	}
	
	

}
