package cts.springBoot1JDBC.dao;

import java.util.List;

import cts.springBoot1JDBC.model.Emp;
//DAO - Data Access Object
public interface EmpDao {
	int saveEmp(Emp e);
	List<Emp> listEmp();

}
