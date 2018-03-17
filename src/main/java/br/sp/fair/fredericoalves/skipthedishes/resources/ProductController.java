package br.sp.fair.fredericoalves.skipthedishes.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sp.fair.fredericoalves.skipthedishes.services.ProductService;

/**
 * Product Controller
 *
 * @author frederico.alves
 *
 */
@RestController
@RequestMapping("/api/v1/order")
public class ProductController {//extends ControllerDefault<Product, ProductService> {

	@Autowired
	private ProductService service;

	
}
