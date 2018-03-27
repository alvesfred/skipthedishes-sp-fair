package br.sp.fair.fredericoalves.skipthedishes;

import org.springframework.beans.factory.annotation.Autowired;

import br.sp.fair.fredericoalves.skipthedishes.model.Product;
import br.sp.fair.fredericoalves.skipthedishes.repository.ProductRepository;

/**
 * Product Service Test
 */
public class ProductServiceTest extends BaseTest<Product, ProductRepository> {

    @Autowired
    private ProductRepository productRepository;

	@Override
	protected ProductRepository getRepository() {
		return productRepository;
	}
}
