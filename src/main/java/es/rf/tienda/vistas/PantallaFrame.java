package es.rf.tienda.vistas;

import java.util.List;

import javax.swing.JFrame;

import es.rf.tienda.controllers.CategoriaController;
import es.rf.tienda.controllers.TControllerSw;
import es.rf.tienda.dominio.Modelo;



public interface PantallaFrame<T extends Modelo> {

	public void setDatos(List<T> lista)  ;
	public JFrame montarPantalla() ;
	public void setRecord(T t, String option);
	public void setController(Object obj);
	
	
	
}
