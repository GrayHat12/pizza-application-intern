package in.ac.sharda.pizzaapplication.service;

import java.util.Collection;
import java.util.List;

import in.ac.sharda.pizzaapplication.domain.Product;

public interface ProductService {
	Product getProductById(int id);

	Collection<Product> getProducts();
}
