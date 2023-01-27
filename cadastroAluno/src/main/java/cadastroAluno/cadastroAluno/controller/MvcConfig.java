package cadastroAluno.cadastroAluno.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MvcConfig  {

	@RequestMapping("/login")
	public String login(){
		
		return "login";
	}
		
	
}
