package model.impl;//Pacote onde estará a implementação do Dao

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import db.DB;
import db.DbExcecao;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class VendedorDaoJDBC implements VendedorDao{
	
	//Instanciado antes da operações e assim, usarei em minhas conexoes abaixo
	private Connection con;
	
	public VendedorDaoJDBC(Connection con) {
		this.con = con;
	}

	@Override
	public void insert(Vendedor obj) {
		
	}

	@Override
	public void update(Vendedor obj) {
		
	}

	@Override
	public void deleteById(Integer id) {
		
	}

	@Override
	public Vendedor findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = con.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller "
					+ "INNER JOIN department ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?");

			st.setInt(1, id);
			rs = st.executeQuery();
			
			//Verifica se tem um vendedor pelo id, senao retorna nulo 
			if(rs.next()) {
				Departamento dep = instanciandoDepartamento(rs);
				
				Vendedor ven = instanciandoDepartamento(rs,dep);
				return ven;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbExcecao(e.getMessage());
		}
		
		finally {
			DB.fechaStatement(st);
			DB.fechaResultSet(rs);
		}
	}

	private Vendedor instanciandoDepartamento(ResultSet rs, Departamento dep) throws SQLException {
		Vendedor ven = new Vendedor();
		ven.setId(rs.getInt("Id"));//Nome da coluna no bd
		ven.setNome(rs.getString("Name"));
		ven.setEmail(rs.getString("Email"));
		ven.setAniversario(rs.getDate("BirthDate"));
		ven.setBaseSalario(rs.getDouble("BaseSalary"));
		ven.setDepartament(dep);//Referenciando o Departmamento
		return ven;
	}

	private Departamento instanciandoDepartamento(ResultSet rs) throws SQLException {
		Departamento dep = new Departamento();
		dep.setId(rs.getInt("DepartmentId"));//Nome da coluna no bd
		dep.setNome(rs.getString("DepName"));//Nome da coluna no bd
		return dep;
	}

	@Override
	public List<Vendedor> findAll() {
		return null;
	}
}
