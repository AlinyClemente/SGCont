package com.sgcont.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sgcont.dados.cadastro.Contador;
import com.sgcont.fachada.Fachada;

@FacesConverter(value="contadorConverter")
public class ContadorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		Fachada fachada = Fachada.getInstance();
		Contador contador = fachada.pesquisarContador(string);
		return contador;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object o) {
		Contador contador = new Contador();
		contador = (Contador) o;

		return contador.getNomeRazaoSocial();
	}

}
