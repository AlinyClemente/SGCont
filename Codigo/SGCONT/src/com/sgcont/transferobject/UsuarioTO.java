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

	private String email;

	private String indicadorUso;

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

	public Usuario getUsuario() {
		Usuario usuario = new Usuario();
		if (this.codigo != null) {
			usuario.setCodigo(new Integer(this.codigo));
		}

		usuario.setNumeroCpf(this.numeroCpf.replace(".", "").replace("-", ""));

		if (this.email != null && !this.email.equals("")) {
			usuario.setEmail(this.email);
		}

		usuario.setNome(this.nome);
		usuario.setLogin(this.login.toLowerCase());
		usuario.setSenha(this.senha);

		if (this.numeroTelefone != null && !this.numeroTelefone.equals("")) {
			usuario.setNumeroTelefone(this.numeroTelefone);
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioTO(Usuario usuario) {
		super();
		this.codigo = usuario.getCodigo().toString();
		this.nome = usuario.getNome();
		this.login = usuario.getLogin();
		if (usuario.getEmail() != null) {
			this.email = usuario.getEmail();
		} else {
			this.email = "";
		}
		this.senha = usuario.getSenha();
		this.indicadorUso = usuario.getIndicadorUso().toString();
		this.numeroCpf = getNumeroCpfFormatado(usuario.getNumeroCpf());

		this.numeroTelefone = usuario.getNumeroTelefone();
	}

	public UsuarioTO() {
		super();

	}

	public String getNumeroCpfFormatado(String cpf) {
		String cpfFormatado = cpf;

		if (cpfFormatado != null && cpfFormatado.length() == 11) {

			cpfFormatado = cpfFormatado.substring(0, 3) + "."
					+ cpfFormatado.substring(3, 6) + "."
					+ cpfFormatado.substring(6, 9) + "-"
					+ cpfFormatado.substring(9, 11);
		}

		return cpfFormatado;

	}
}
