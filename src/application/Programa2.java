package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFabrica;
import model.dao.DepartamentoDao;
import model.entities.Departamento;

public class Programa2 {

	public static void main(String[] args) {

		DepartamentoDao departamentoDao = DaoFabrica.createDepartamentoDao();

		System.out.println("##Teste 1: Departamento findById##");
		
		Departamento departamento = departamentoDao.findById(1);
		System.out.println(departamento);
	/*----------------------------------------------------------------------------*/
		System.out.println("\n##Teste 2: Departamento findAll##");

		List<Departamento> list1 = departamentoDao.findAll();

		for (Departamento dep : list1) {
			System.out.println(dep);
		}
	/*----------------------------------------------------------------------------*/
		System.out.println("\n##Teste 3: Departamento Insert##");
		
		Departamento novoDepartamento = new Departamento(null,"Musica");
		
		departamentoDao.insert(novoDepartamento);//Recebe o objeto de DepartamentoDao
		System.out.println("Inserido! Novo id: " +novoDepartamento.getId());//Para verificar se trouxe o id
	/*----------------------------------------------------------------------------*/
		System.out.println("\n##Teste 4: Departamento Update##");
		
		Departamento departamento02 = departamentoDao.findById(1);//Carrego os dados do vendedor com id = 1 no objeto vendedor
		
		departamento02.setNome("Alimentos");
		
		departamentoDao.update(departamento02);
		System.out.println("Atualização completa");
	/*----------------------------------------------------------------------------*/
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n##Teste 5: Departamento Delete##");
		
		System.out.printf("Informe o identificador que será excluído: ");
		int id = sc.nextInt();
		
		departamentoDao.deleteById(id);
		
		System.out.println("Exclusão completa");
		
		sc.close();
	/*----------------------------------------------------------------------------*/
	}
}
