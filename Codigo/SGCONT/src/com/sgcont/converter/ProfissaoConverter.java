package com.sgcont.converter;

import java.util.HashMap;
import java.util.Map;

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

		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("codigo", string);
		
		Profissao profissao = (Profissao) 
				fachada.pesquisar(Profissao.class, parametros);
		
		return profissao;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object o) {
		Profissao profissao = new Profissao();
		profissao = (Profissao) o;

		return profissao.getCodigo().toString();
	}

}
