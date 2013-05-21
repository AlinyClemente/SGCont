package com.sgcont.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sgcont.dados.cadastro.EmpresaContabil;
import com.sgcont.fachada.Fachada;


@FacesConverter(value="empresaContabilConverter")
public class EmpresaContabilConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		Fachada fachada = Fachada.getInstance();
		EmpresaContabil empresaContabil = fachada.pesquisarEmpresaContabil(string);
		return empresaContabil;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object o) {
		EmpresaContabil empresaContabil = new EmpresaContabil();
		empresaContabil = (EmpresaContabil) o;

		return empresaContabil.getNomeFantasia();
	}


}
