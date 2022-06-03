package application;

import java.util.Date;
import java.util.List;
import model.dao.DaoFabrica;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class Programa {

	public static void main(String[] args) {

		VendedorDao vendedorDao = DaoFabrica.createVendedorDao();

		System.out.println("##Teste 1: Vendedor findById##");
		Vendedor vendedor = vendedorDao.findById(3);
		System.out.println(vendedor);

		System.out.println("\n##Teste 2: Vendedor findByDepartamento##");

		Departamento departamento = new Departamento(2, null);

		List<Vendedor> list1 = vendedorDao.findByDepartamento(departamento);

		// if (list1 != null) {

		for (Vendedor ven : list1) {

			System.out.println(ven);
			/*
			 * System.out.println(ven.getId() + ven.getNome() + " - " + ven.getEmail() +
			 * " - " + ven.getAniversario() + " - " + ven.getBaseSalario() + " - " +
			 * ven.getDepartament());
			 */
		}

		System.out.println("\n##Teste 3: Vendedor findAll##");
		list1 = vendedorDao.findAll();//Usando a mesma lista nao precisa ter a declaração da lista antes
		
		for (Vendedor ven : list1) {
			System.out.println(ven);
		}
		
		System.out.println("\n##Teste 3: Vendedor Insert##");
		Vendedor novoVendedor = new Vendedor(null,"Greg","greg@gmail.com",new Date(),4000.0,departamento);
		vendedorDao.insert(novoVendedor);
		
		System.out.println("Inserido! Novo id: " +novoVendedor.getId());//Para verificar se trouxe o id
	}
}
