package com.sgcont.transferobject;

import java.io.Serializable;

import com.sgcont.dados.cadastro.Usuario;

public class UsuarioTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codigo;

	private String nome;

	private String login;

	private String senha;

	private String numeroCpf;

	private String numeroTelefone;

	private String nnfax;

	private String email;

	private String indicadorUso;

	private String indicadorResponsavel;

	private Usuario usuario;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	

	public String getNumeroCpf() {
		return numeroCpf;
	}

	public void setNumeroCpf(String numeroCpf) {
		this.numeroCpf = numeroCpf;
	}


	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getNnfax() {
		return nnfax;
	}

	public void setNnfax(String nnfax) {
		this.nnfax = nnfax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndicadorUso() {
		return indicadorUso;
	}

	public void setIndicadorUso(String indicadorUso) {
		this.indicadorUso = indicadorUso;
	}

	public String getIndicadorResponsavel() {
		return indicadorResponsavel;
	}

	public void setIndicadorResponsavel(String indicadorResponsavel) {
		this.indicadorResponsavel = indicadorResponsavel;
	}

	public Usuario getUsuario() {
		Usuario  usuario = new Usuario ();

		usuario.setNumeroCpf(this.numeroCpf
				.replace(".", "")
				.replace("-", ""));

		if(this.email !=null && !this.email.equals("")){
			usuario.setEmail(this.email);
		}
		
		usuario.setNome(this.nome);
		usuario.setLogin(this.login.toLowerCase());
		usuario.setSenha(this.senha);
		
		if(this.numeroTelefone !=null 
				&& !this.numeroTelefone.equals("")){
		usuario.setNumeroTelefone(this.numeroTelefone);
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
