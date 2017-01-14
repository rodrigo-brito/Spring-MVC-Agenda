package net.rodrigobrito.agenda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class Contato {
	
	@Id
	@GeneratedValue
	private long id;
	@NotNull
	private String nome;
	@NotNull
	@Size(min=8,max=15)
	private String telefone;
	@Email
	private String email;
	
	public Contato() { }
	
	public Contato(String nome, String telefone, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", telefone=" + telefone + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		if (this.getClass() != obj.getClass()){
			return false;
		}
		Contato contato = (Contato) obj;
		return this.getId() == contato.getId() &&
				this.getNome() == contato.getNome() &&
				this.getTelefone() == contato.getTelefone();
	}
}
