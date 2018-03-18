package br.sp.fair.fredericoalves.skipthedishes.resources;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sp.fair.fredericoalves.skipthedishes.model.Product;
import br.sp.fair.fredericoalves.skipthedishes.services.ProductService;

/**
 * Store Controller
 *
 * @author frederico.alves
 *
 */
@RestController
@RequestMapping("/api/v1/store")
public class StoreController {//extends ControllerDefault<Product, ProductService> {

	@Autowired
	protected ProductService service;

	@GetMapping("/list")
	public Collection<Product> get() {
		return service.findAll();
	}

	@GetMapping("/get/{id}")
	public Product get(@PathVariable Long id) {
		return service.findOne(id);
	}
}
