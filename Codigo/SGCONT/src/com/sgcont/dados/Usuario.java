package com.sgcont.dados;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name="id")
	@Column(nullable=false)
	private Integer id;
	
	@Column
	private String login;

	@Column
	private String senha;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
