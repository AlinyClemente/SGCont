package com.sgcont.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sgcont.dados.cadastro.TipoReceita;
import com.sgcont.fachada.Fachada;


@FacesConverter(value="tipoReceitaConverter")
public class TipoReceitaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		Fachada fachada = Fachada.getInstance();
		TipoReceita tipoReceita = fachada.pesquisarTipoReceita(string);
		return tipoReceita;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object o) {
		TipoReceita tipoReceita = new TipoReceita();
		tipoReceita = (TipoReceita) o;

		return tipoReceita.getDescricao();
	}


}
