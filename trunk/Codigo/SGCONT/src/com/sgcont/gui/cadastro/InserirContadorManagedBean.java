package com.sgcont.gui.cadastro;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sgcont.dados.cadastro.EmpresaContabil;
import com.sgcont.dados.cadastro.Endereco;
import com.sgcont.fachada.Fachada;
import com.sgcont.transferobject.ContadorTO;


/**
 * [UC003] Inserir Contador 
 * 
 * @author Rômulo Aurélio
 * @since 11/05/2013
 * */
@ManagedBean (name="InserirContadorBean")
@SessionScoped
public class InserirContadorManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ContadorTO contadorTO;
	
	private Collection<Endereco> colecaoEndereco;
	private Collection<EmpresaContabil> colecaoEmpresaContabil;
	
	
	public Collection<EmpresaContabil> getColecaoEmpresaContabil() {
		return colecaoEmpresaContabil;
	}

	public void setColecaoEmpresaContabil(
			Collection<EmpresaContabil> colecaoEmpresaContabil) {
		this.colecaoEmpresaContabil = colecaoEmpresaContabil;
	}

	

	/**
	 * [UC003] Inserir Contador
	 * 
	 * @author Rômulo Aurélio
	 * @since 11/05/2013
	 * */
	public String exibirInserirContador() {

		Fachada fachada = Fachada.getInstance();
		
		this.colecaoEmpresaContabil = (Collection<EmpresaContabil>) 
				fachada.pesquisar(EmpresaContabil.class);
		
		return "inserir_contador";
		
	}	
	
	
	/**
	 * [UC003] Inserir Contador
	 * 
	 * @author Rômulo Aurélio
	 * @since 11/05/2013
	 * */
	public String cadastrar() {

		Fachada fachada = Fachada.getInstance();
		
		fachada.inserirContador(this.contadorTO);
		
		return "tela_sucesso";
		
	}

}
