package es.rf.tienda.objetos.daos;

import java.sql.ResultSet;
import java.sql.SQLException;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.Rutinas;
import es.rf.tienda.util.Validator;

public class BOCategoria extends BObjetosDAO<Categoria> {

	public BOCategoria() {
		super(new Categoria());
	}

	public String obtenLista(Categoria clase, String separador) {
		String salida = "";
		if (clase.getId_categoria() > 0) {
			salida = Rutinas.addCampo(salida, "id_Categoria", clase.getId_categoria(), separador);
		}
		if ((clase.getCat_nombre() != null && clase.getCat_nombre().compareTo("") != 0) || separador.equals(",")) {
			salida = Rutinas.addCampo(salida, "cat_nombre", clase.getCat_nombre(), separador);
		}
		if ((clase.getCat_descripcion() != null && clase.getCat_descripcion().compareTo("") != 0)
				|| separador.equals(",")) {
			salida = Rutinas.addCampo(salida, "cat_descripcion", clase.getCat_descripcion(), separador);
		}
		return salida;
	}
	
	public String obtenInsert(Categoria clase) {
		String salida = "";
		salida = Rutinas.addCampo(salida, "", clase.getId_categoria(), ",");
		salida = Rutinas.addCampo(salida, "", clase.getCat_nombre(), ",");
		salida = Rutinas.addCampo(salida, "", clase.getCat_descripcion(), ",");
		return salida;
	}
	
	public Categoria montaRegistro(ResultSet rs) throws DomainException, DAOException {
		Categoria salida = new Categoria();
		try {
			salida.setId_categoria(rs.getInt("Id_categoria"));
			salida.setCat_nombre(rs.getString("Cat_nombre"));
			salida.setCat_descripcion(rs.getString("Cat_descripcion"));
		} catch (SQLException e) {
			throw new DAOException("Error " + e.getMessage() + "\nen montaRegistro" );
		}
		return salida;
	}


}
