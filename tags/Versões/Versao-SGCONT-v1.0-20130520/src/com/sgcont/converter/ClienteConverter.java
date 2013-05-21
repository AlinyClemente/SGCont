package com.sgcont.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sgcont.fachada.Fachada;
import com.sgcont.transferobject.ClienteTO;

@FacesConverter(value="clienteTOConverter")
public class ClienteConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		Fachada fachada = Fachada.getInstance();
		ClienteTO clienteTO = fachada.pesquisarClienteTO(string);
		return clienteTO;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object o) {
		ClienteTO clienteTO = new ClienteTO();
		clienteTO = (ClienteTO) o;

		return clienteTO.getCodigo();
	}

}
