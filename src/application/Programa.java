package application;

import model.dao.DaoFabrica;
import model.dao.VendedorDao;
import model.entities.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		VendedorDao vendedorDao = DaoFabrica.createVendedorDao();
		
		System.out.println("##Teste 1: Vendedor findById##");
		Vendedor vendedor = vendedorDao.findById(3);
		System.out.println(vendedor);
	}
}
