package com.sgcont.converter;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sgcont.dados.cadastro.Banco;
import com.sgcont.fachada.Fachada;

@FacesConverter(value="bancoConverter")
public class BancoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		Fachada fachada = Fachada.getInstance();

		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("codigo", string);
		
		Banco banco = (Banco) 
				fachada.pesquisar(Banco.class, parametros);
		
		return banco;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object o) {
		Banco banco = new Banco();
		banco = (Banco) o;

		return banco.getCodigo().toString();
	}

}
