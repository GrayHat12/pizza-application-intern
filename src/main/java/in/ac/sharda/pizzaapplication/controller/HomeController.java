package in.ac.sharda.pizzaapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.ac.sharda.pizzaapplication.data.Products;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model){
		model.addAttribute("products", Products
				.getInstance().getProducts().values());
		return "home";
	}
}
