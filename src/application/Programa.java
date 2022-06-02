package application;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.dao.DaoFabrica;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		//Departamento obj = new Departamento(1,"Livros");
		
		//Vendedor vendedor = new Vendedor(21,"Bob","bob@gmail.com",new Date(),3000.0,obj);
		
		//O programa só conhece a instanciação, nao a implementação
		//VendedorDao vendedorDao = new DaoFabrica().createVendedorDao();
		
		VendedorDao vendedorDao = DaoFabrica.createVendedorDao();
		Vendedor vendedor = vendedorDao.findById(3);
		System.out.println(vendedor);
	}
}
