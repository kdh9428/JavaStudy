package junittest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import aop.logExecution;

@Controller
public class Acontroller {
	
	private final AService aService;
	
	public Acontroller(AService aService) {
		this.aService = aService;
	}
	
	@logExecution
	@GetMapping("testa")
	public String testa(@RequestParam String a) throws Exception{
		System.out.println(a);
		aService.aopTest("a");
		return "home";
	}
}
