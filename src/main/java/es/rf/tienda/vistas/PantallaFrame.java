package es.rf.tienda.vistas;

import java.util.List;

import es.rf.tienda.controllers.TControllerSw;
import es.rf.tienda.dominio.Modelo;



public interface PantallaFrame<S extends Modelo<S>> {

	public void setDatos(List<S> lista)  ;    			//Para listado
	public void setRecord(S s, String option);			//para formulario
	public void setController(TControllerSw obj);		// recibe el controlador
	
	
	
}
