package in.ac.sharda.pizzaapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.ac.sharda.pizzaapplication.domain.Product;
import in.ac.sharda.pizzaapplication.service.ProductService;
import in.ac.sharda.pizzaapplication.data.Song;
import in.ac.sharda.pizzaapplication.data.Songs;
import in.ac.sharda.pizzaapplication.data.SongData;

@RestController
public class ProductDetailController {
	@Autowired
	private ProductService productService;

	@GetMapping("/product/detail/{id}")
	public Product detail(@PathVariable("id") int id) {
		return productService.getProductById(id);
	}
	
	@GetMapping("/songs/list/{query}")
	public List<Song> sdetail(@PathVariable("query") String query)
	{
		Songs ob=new Songs(query);
		return ob.getSongs();
	}
	
	@GetMapping("/songs/data/{id}")
	public Song songDetail(@PathVariable("id") String query)
	{
		SongData ob=new SongData(query);
		return ob.getData();
	}
}
