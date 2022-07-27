package es.rf.tienda.controllers;

import java.util.List;
import java.util.Map;

import es.rf.tienda.exception.DAOException;

public interface Controlador<S> {
	
	public S leer(S obj);
	public List<S> leerTodos();
	public List<S> leerSQL(String sql);
	public void grabar(S obj) throws DAOException;
	public boolean actualizar(S obj) throws DAOException;
	public boolean borrar(S obj) throws DAOException;
	public Map<String,String> obtenSelect();
	


}
