package cts.springBoot1JDBC;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class Form1Controller {
	
	@RequestMapping("/")
	public String wel() {
		return "index";
	}
  
	@RequestMapping("/Form1")
	public String showForm() {
		return "Form1";
	}
	
	@RequestMapping("/Form1Submit")
    public String handleFormSubmit(@RequestParam("name") String name, Model model) throws NameException {
        if(name.length()<=1) {
        	throw new NameException("Name should be atleast 2 chars long");
        }
        
        String reverseName=new StringBuilder(name).reverse().toString();
        model.addAttribute("reverseName",reverseName);
        return "Form1Result";
    }
	
	
	@ExceptionHandler(NameException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String handleException(NameException ne) {
		System.out.println("***handleException()");
		ErrorResponse er=new ErrorResponse(ne.getMessage());
		return "<h2>"+er+"</h2>";
	}
	
}
