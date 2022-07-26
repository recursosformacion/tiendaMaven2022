package es.rf.tienda.controllers;

import java.util.Map;


import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.objetos.daos.BOCategoria;
import es.rf.tienda.util.Validator;
import es.rf.tienda.vistas.FrCategoria;
import es.rf.tienda.vistas.LCCategoria;

/**
 * Servlet implementation class ListCategoria
 */

public class CategoriaController extends TControllerSw<Categoria, BOCategoria> {
	
	public CategoriaController() throws DAOException, DomainException {
		super(new Categoria(), new BOCategoria(), LCCategoria.getInstance(), FrCategoria.getInstance());
	}

	@Override
	public Categoria montaObj(Map<String, String[]> m) throws DomainException {
		Categoria gestor = new Categoria();

			int id_categoria = 0;
			String id = m.get("id")[0];
			if (id != null && Validator.isNumeric(id))
				id_categoria = Integer.parseInt(id);

			gestor.setId_categoria(id_categoria);
			if (m.get("cat_nombre") != null)
				gestor.setCat_nombre(m.get("cat_nombre")[0]);
			if (m.get("cat_descripcion") != null)
				gestor.setCat_descripcion(m.get("cat_descripcion")[0]);
	//	}
		return gestor;
	}

	@Override
	public Map<String, String> obtenSelect() {
		// TODO Auto-generated method stub
		return null;
	}
}
