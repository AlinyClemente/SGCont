package com.sgcont.converter;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.fachada.Fachada;

@FacesConverter(value="usuarioConverter")
public class UsuarioConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		Fachada fachada = Fachada.getInstance();

		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("codigo", string);
		
		Usuario usuario = (Usuario) 
				fachada.pesquisar(Usuario.class, parametros);
		
		return usuario;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object o) {
		Usuario usuario = new Usuario();
		usuario = (Usuario) o;

		return usuario.getCodigo().toString();
	}

}
