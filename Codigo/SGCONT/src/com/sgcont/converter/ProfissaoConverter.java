package com.sgcont.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sgcont.dados.cadastro.Profissao;
import com.sgcont.fachada.Fachada;

@FacesConverter(value="profissaoConverter")
public class ProfissaoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		Fachada fachada = Fachada.getInstance();
		Profissao profissao = fachada.pesquisarProfissao(string);
		return profissao;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object o) {
		Profissao profissao = new Profissao();
		profissao = (Profissao) o;

		return profissao.getNomeProfissao();
	}

}
