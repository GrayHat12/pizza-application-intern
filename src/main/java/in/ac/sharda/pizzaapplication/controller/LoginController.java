package in.ac.sharda.pizzaapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.ac.sharda.pizzaapplication.domain.LoginData;

@RestController
public class LoginController {

	@GetMapping("/login")
	public LoginData login() {
		return new LoginData();
	}

	@PostMapping("/login")
	public boolean login(@RequestBody LoginData ld) {
		if (ld.getPassword() != null 
				&& ld.getUserName() != null) {
			if(ld.getPassword().equals("abc") 
					&& ld.getUserName().equals("abc")){
				return true;
			}
		}
		
		return false;
	}
}
