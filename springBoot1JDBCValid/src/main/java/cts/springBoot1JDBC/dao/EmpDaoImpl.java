package cts.springBoot1JDBC.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cts.springBoot1JDBC.model.Emp;

@Repository
public class EmpDaoImpl implements EmpDao{

	private JdbcTemplate tmp;
	
	public EmpDaoImpl(DataSource dataSource) {
		System.out.println("EmpDaoImpl(DataSource dataSource)");
		tmp=new JdbcTemplate(dataSource);
		System.out.println("JdbcTemplated obj created");
	}
	
	@Override
	public int saveEmp(Emp e) {
		int cnt=tmp.update("Insert into Emp values (?,?,?)", e.getEmpno(), e.getName(), e.getSalary());
		System.out.println(cnt+" record updated");
		return cnt;
	}

	@Override
	public List<Emp> listEmp() {
		// TODO Auto-generated method stub
		return null;
	}
	
	class EmpRowMapper implements RowMapper<Emp>{

		@Override
		public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
			Emp e=new Emp();
			e.setEmpno(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setSalary(rs.getFloat(3));
			return e;
		}
		
	}

}
