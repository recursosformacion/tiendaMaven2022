package es.rf.tienda.controllers;

import java.util.List;
import java.util.Map;
import es.rf.tienda.dominio.Modelo;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.objetos.daos.BObjetosDAO;
import es.rf.tienda.vistas.PantallaFrame;

/**
 * Servlet implementation class ListCategoria
 */

public abstract class TControllerSw<S extends Modelo<S>, T extends BObjetosDAO<S>> implements Controlador<S> {

	private T cDAO;
	private S gestor;
	private PantallaFrame<S> listado; // Frame para el listado
	private PantallaFrame<S> formulario; // Frame para el formulario

	public static final String ID = "id";

	public static final String ADD = "add";
	public static final String VIEW = "ver";
	public static final String UPDATE = "upd";
	public static final String DELETE = "del";
	public static final String LIST = "lis";

	public TControllerSw() {
		super();
	}

	public TControllerSw(S objeto, T cDAO, PantallaFrame<S> listado, PantallaFrame<S> formulario) {
		super();
		this.cDAO = cDAO;
		this.listado = listado;
		this.formulario = formulario;
		this.gestor = objeto;

		formulario.setController(this); // Le asigno al formulario, este controlador
	}

	public List<S> listado() {
		List<S> lista = null;
		try {
			lista = cDAO.leerTodos();
		} catch (DAOException e) {
			e.printStackTrace();
		} catch (DomainException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public void setOption(String[] sentencia) {
		String option = sentencia[0];
		String clave = "";
		gestor.clean();
		S obj = (S) gestor.clone();
		if (sentencia.length >= 2) {
			clave = sentencia[1];
			System.out.println(clave);
			obj.setId(Integer.parseInt(clave));
		}
		try {
			switch (option) {
			case ADD:
				formulario.setRecord(gestor, option);
				formulario.setController(this);
				break;
			case VIEW:
			case UPDATE:
			case DELETE:
				formulario.setRecord(leer(obj), option);
				formulario.setController(this);
				break;
			case LIST:
				List<S> lista = leerTodos();
				listado.setController(this);
				listado.setDatos(lista);
				

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void setAction(String accion, S obj) {

		try {
			switch (accion) {
			case ADD:
				grabar(obj);
				break;
			
			case UPDATE:
				actualizar(obj);
				break;
			case DELETE:
				borrar(obj);
				break;

			case LIST:
			case VIEW:

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		setOption(new String[] { TControllerSw.LIST });
	}

	public S leer(S obj) {
		try {
			return cDAO.leerRegistro(obj);
		} catch (DAOException | DomainException e) {

			e.printStackTrace();
		}
		return null;
	}

	public List<S> leerTodos() {
		try {
			return cDAO.leerTodos();
		} catch (DAOException | DomainException e) {

			e.printStackTrace();
		}
		return null;
	}

	public List<S> leerSQL(String sql) {
		try {
			return cDAO.leerSQL(sql);
		} catch (DAOException | DomainException e) {

			e.printStackTrace();
		}
		return null;
	}

	public void grabar(S obj) throws DAOException {
		if (cDAO.insertarRegistro(obj))
			setOption(new String[] { TControllerSw.LIST });
	}

	public boolean actualizar(S obj) throws DAOException {
		return cDAO.actualiza(obj);
	}

	public boolean borrar(S obj) throws DAOException {
		return cDAO.borrarRegistro(obj);
	}

//	public Map<String, String> obtenSelect() {
//		return cDAO.(obj);
//	}

	public abstract S montaObj(Map<String, String[]> map) throws DomainException;
}
