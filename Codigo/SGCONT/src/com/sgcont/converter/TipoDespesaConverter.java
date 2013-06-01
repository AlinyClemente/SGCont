package com.sgcont.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sgcont.dados.operacional.TipoDespesa;
import com.sgcont.fachada.Fachada;

@FacesConverter(value="tipoDespesaConverter")
public class TipoDespesaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		Fachada fachada = Fachada.getInstance();
		TipoDespesa tipoDespesa = fachada.pesquisarTipoDespesa(string);
		return tipoDespesa;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object o) {
		TipoDespesa tipoDespesa = new TipoDespesa();
		tipoDespesa = (TipoDespesa) o;

		return tipoDespesa.getDescricao();
	}

}
