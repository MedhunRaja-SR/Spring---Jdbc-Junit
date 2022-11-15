package cts.springBoot1JDBC;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import cts.springBoot1JDBC.dao.EmpDao;
import cts.springBoot1JDBC.model.Emp;

@Controller
public class Form2Controller {
	
	@Autowired  //instead of Autowired, we can also use the construction injection below.
	private EmpDao dao;
	
	//Construction Injection
//	public Form2Controller(EmpDao dao) {
//		System.out.println("Form2Controller(EmpDao)");
//		this.dao=dao;
//	}

	@RequestMapping("/Form2")
	public String showForm(@ModelAttribute("emp") Emp emp) {
		return "Form2";
	}
	
	@RequestMapping("/Form2Submit")
	public String handleFormSubmit(@Valid @ModelAttribute("emp") Emp e, BindingResult bindingResult, Model m) {
		System.out.println(e);
		System.out.println("empno:"+e.getEmpno()+" Name:"+e.getName()+" Salary:"+e.getSalary());
		boolean hasErrors=bindingResult.hasErrors();
		if(hasErrors) {
			System.out.println("bindingResult.hasErrors():"+hasErrors);
			List<ObjectError> errs=bindingResult.getAllErrors();
			System.out.println(errs);
			return "Form2";
		}
		else {
			int cnt=dao.saveEmp(e);
		    System.out.println("cnt "+cnt);
		    m.addAttribute("cnt", cnt);
		    return "Form2Result";
		}
		
	}
	
	@RequestMapping("/empList")
	public String showEmpList(Model m) {
		
		List<Emp> empList=dao.listEmp();
		System.out.println("Form2Controller got empList from EmpDaoImpl");
		m.addAttribute("empList", empList);
		return("EmpList");
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) {
		System.out.println("***handleException()");
		ModelAndView mv=new ModelAndView("Form2");
		mv.addObject("emp", new Emp());
		mv.addObject("error", e.getMessage());
		return mv;
	}
	
}