package com.sgcont.converter;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sgcont.dados.cadastro.ClientePessoaJuridica;
import com.sgcont.fachada.Fachada;

@FacesConverter(value="clientePjConverter")
public class ClientePJConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		Fachada fachada = Fachada.getInstance();

		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("cliente.nome", string);
		
		ClientePessoaJuridica clientePessoaJuridica = (ClientePessoaJuridica) 
				fachada.pesquisar(ClientePessoaJuridica.class, parametros);
		
		return clientePessoaJuridica;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object o) {
		ClientePessoaJuridica clientePessoaJuridica = new ClientePessoaJuridica();
		clientePessoaJuridica = (ClientePessoaJuridica) o;

		return clientePessoaJuridica.getCliente().getNome();
	}

}
