package es.rf.tienda.objetos.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.dominio.Modelo;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.RFDataConnection;
import es.rf.tienda.util.Rutinas;
import es.rf.tienda.util.Validator;

public abstract class BObjetosDAO<T extends  Modelo> {
	
	private T modelo;
	
	private final String SELECT = "SELECT * FROM ";
	private final String UPDATE = "UPDATE  ";
	private final String INSERT = "INSERT INTO ";
	private final String DELETE = "DELETE ON ";

	BObjetosDAO(T modelo){
		this.modelo = modelo;
	}
	

	public T leerRegistro(T clase) throws DAOException, DomainException  {
		T nueva;
		String res = obtenWhere(clase);
		String sql = SELECT + clase.getTabla() + " " + res;
		
		ResultSet rs = RFDataConnection.ejecutarQuery(sql);
		try {
			rs.next();
			if (rs.isLast()) {
				return montaRegistro(rs);
			} else
				throw new DAOException("Demasiados registros en " + sql);
		} catch (SQLException e) {
			throw new DAOException("Error " + e.getMessage() + "\nen " + sql);
		}
	}


	private String obtenWhere(T clase) {

		String salida = obtenLista(clase, "AND");
		if (salida.length() > 0)
			salida = "WHERE " + salida;
		return salida;
	}

	
	


	


	public List<T> leerTodos() throws DAOException, DomainException {
		String sql = SELECT + modelo.getTabla();
		return montaLista(sql);
		
	}

	


	public List<T> leerRegistros(T clase) throws DAOException, DomainException {
		String where = obtenWhere(clase);
		String sql = SELECT + clase.getTabla() + where;
		return montaLista(sql);
	}
	
	private List<T> montaLista(String sql) throws DAOException, DomainException {
		ResultSet rs = RFDataConnection.ejecutarQuery(sql);
		List<T> lista = new ArrayList<T>();
		try {
			while (rs.next()) {
				lista.add(montaRegistro(rs));
			}
		
		} catch (SQLException e) {
			throw new DAOException("Error " + e.getMessage() + "\nen "+ sql);	
		}
		return lista;
	}


	public boolean actualiza(T clase) throws DAOException {
		String where = " WHERE " + clase.getNombrePk() +  " = " + clase.getId();
		int tmp = clase.getId();
		clase.setId(0);
		String update = obtenUpdate(clase);
		clase.setId(tmp);
		String sql = UPDATE + clase.getTabla() + update + where;
		return RFDataConnection.ejecutar(sql)>1;
	}

	private String obtenUpdate(T clase) {
		return obtenLista(clase, ",");
	}

	public boolean insertarRegistro(T clase) throws DAOException {
		clase.setId(RFDataConnection.consigueClave(clase.getTabla(), clase.getNombrePk()));
		String salida = obtenInsert(clase);
		String sql = INSERT + clase.getTabla() + "(" + salida + ")";
		System.out.println(sql);
		int ret = RFDataConnection.ejecutar(sql);
		if (ret == 0)
			throw new DAOException("Error en " + sql);
		return true;
	}


	


	public boolean borrarRegistro(T clase) throws DAOException {
		String where = obtenWhere(clase);
		String sql = DELETE + clase.getTabla()  + where;
		return RFDataConnection.ejecutar(sql)>0;
		
	}


	public List<T> leerSQL(String where) throws DAOException, DomainException {
		String sql = SELECT + modelo.getTabla()  + "WHERE" + where;
		return montaLista(sql);
	}

	protected abstract String obtenInsert(T clase);
	protected abstract String obtenLista(T clase, String string);
	protected abstract T montaRegistro(ResultSet rs) throws DomainException, DAOException;
	
}
