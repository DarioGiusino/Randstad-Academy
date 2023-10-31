package com.example.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titolo;
	private String genere;

//	@ManyToOne
//	private Membro membro;

	@ManyToMany(mappedBy = "libri")
	private Set<Membro> membri = new HashSet<>();

	public Libro() {
	}

	public Libro(Long id, String titolo, String genere) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.genere = genere;
	}

	public Libro(Long id, String titolo, String genere, Set<Membro> membri) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.genere = genere;
		this.membri = membri;
	}

//	public Libro(Long id, String titolo, String genere, Membro membro) {
//		super();
//		this.id = id;
//		this.titolo = titolo;
//		this.genere = genere;
//		this.membro = membro;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public Set<Membro> getMembri() {
		return membri;
	}

	public void setMembri(Set<Membro> membri) {
		this.membri = membri;
	}


//	public Membro getMembro() {
//		return membro;
//	}
//
//	public void setMembro(Membro membro) {
//		this.membro = membro;
//	}

}
