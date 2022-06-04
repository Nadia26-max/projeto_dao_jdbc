package model.dao;

import db.DB;
import model.impl.DepartamentoDaoJDBC;
import model.impl.VendedorDaoJDBC;

public class DaoFabrica {

	// Deixa a interface e oculta a implementa��o
	public static VendedorDao createVendedorDao() {// Vai retornar a classe VendedorDao - Retorna o tipo da interface

		return new VendedorDaoJDBC(DB.getConexao());// Internamente vai instanciar uma implementa��o
	}

	public static DepartamentoDao createDepartamentoDao() {
		return new DepartamentoDaoJDBC(DB.getConexao());
	}
}
