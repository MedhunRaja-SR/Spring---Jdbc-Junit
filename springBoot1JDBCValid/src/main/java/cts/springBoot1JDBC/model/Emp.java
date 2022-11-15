package cts.springBoot1JDBC.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Emp {
	
	   @NotNull
	   @Min(value=1,message="Minimun value should me 1.")
	   private int empno;
	   
	   @Size(min = 2,message="Min size of name should be 2 chars")
	   private String name;
	   
	   private double salary;
	   
	   public int getEmpno() {
		   return empno;
	   }
	   
	   public void setEmpno(int empno) {
		   this.empno = empno;
	   }
	   
	   public String getName() {
		   return name;
	   }
	   
	   public void setName(String name) {
		   this.name = name;
	   }
	   
	   public double getSalary() {
		   return salary;
	   }
	   
	   public void setSalary(double salary) {
		   this.salary = salary;
	   }
	}