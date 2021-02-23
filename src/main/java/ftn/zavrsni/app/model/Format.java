package ftn.zavrsni.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="formati")
public class Format {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	
	@Column(nullable = true)
    private String tip;
	
	@Column
    private int broj;
	
	@OneToMany(mappedBy = "format", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Takmicenje> takmicenja = new ArrayList<>();

	public Format() {
		super();
	}

	public Format(Long id, String tip, int broj) {
		super();
		this.id = id;
		this.tip = tip;
		this.broj = broj;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Format other = (Format) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

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

	@Override
	public String toString() {
		return "Format [id=" + id + ", tip=" + tip + ", broj=" + broj + "]";
	}

	
	
	
	
	
 	

}
