package com.sgcont.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sgcont.dados.cadastro.ClientePessoaFisica;
import com.sgcont.fachada.Fachada;

@FacesConverter(value="clienteConverter")
public class ClientePFConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		Fachada fachada = Fachada.getInstance();
		ClientePessoaFisica clientePessoaFisica = fachada.pesquisarClientePF(string);
		return clientePessoaFisica;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object o) {
		ClientePessoaFisica clientePessoaFisica = new ClientePessoaFisica();
		clientePessoaFisica = (ClientePessoaFisica) o;

		return clientePessoaFisica.getCliente().getNome();
	}

}
