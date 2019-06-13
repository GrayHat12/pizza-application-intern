package in.ac.sharda.pizzaapplication.controller;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ac.sharda.pizzaapplication.domain.Product;
import in.ac.sharda.pizzaapplication.domain.User;

@RestController
public class OrderHistoryController {

	@GetMapping("/order/history")
	public List<Set<Product>> history(){
		return User.getInstance().getOrderStatus();
	}
}
