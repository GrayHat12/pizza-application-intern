package in.ac.sharda.pizzaapplication.controller;

import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ac.sharda.pizzaapplication.domain.Cart;
import in.ac.sharda.pizzaapplication.domain.Product;

@RestController
public class CartController {
	private Cart cart = Cart.getInstance();
	
	public Set<Product> listProducts(){
		return cart.getProducts();
	}
	
	@GetMapping("/remove/product")
	public void removeItem(Product product){
		cart.removeProduct(product);
	}
	

	@GetMapping("/cart/products/count")
	public int count(){
		return cart.getProducts().size();
	}
	
	@PostMapping("/cart/add/product")
	public boolean addProduct(@RequestBody 
			Product product){
		return cart.getProducts().add(product);
	}
}
