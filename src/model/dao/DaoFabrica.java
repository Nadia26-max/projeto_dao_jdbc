package model.dao;

import java.util.List;

import model.entities.Vendedor;

public class DaoFabrica {

	//Deixa a interface e oculta a implementação
	public static VendedorDao createVendedorDao() {// Vai retornar a classe VendedorDao - Retorna o tipo da interface

		return new VendedorDao() {//Internamente vai instanciar uma implementação

			@Override
			public void update(Vendedor obj) {

			}

			@Override
			public void insert(Vendedor obj) {

			}

			@Override
			public Vendedor findById(Integer id) {
				return null;
			}

			@Override
			public List<Vendedor> findAll() {
				return null;
			}

			@Override
			public void deleteById(Integer id) {
				// TODO Auto-generated method stub

			}
		};
	}
}
