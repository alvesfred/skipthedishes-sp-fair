package br.sp.fair.fredericoalves.skipthedishes;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.sp.fair.fredericoalves.skipthedishes.model.Product;
import br.sp.fair.fredericoalves.skipthedishes.repository.ProductRepository;

/**
 * Product Service Test
 */
public class ProductServiceTest extends BaseTest<Product, ProductRepository> {

    @Autowired
    private ProductRepository productRepository;

    public ProductServiceTest() {
    	super(LoggerFactory.getLogger(ProductServiceTest.class));
    }

	@Override
	protected ProductRepository getRepository() {
		return productRepository;
	}
}
