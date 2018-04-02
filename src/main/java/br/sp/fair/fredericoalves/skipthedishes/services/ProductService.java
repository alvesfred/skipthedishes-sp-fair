package br.sp.fair.fredericoalves.skipthedishes.services;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sp.fair.fredericoalves.skipthedishes.model.Product;
import br.sp.fair.fredericoalves.skipthedishes.repository.ProductRepository;

/**
 * Product Service
 *
 * @author frederico.alves
 *
 */
@Service
public class ProductService extends BusinessServiceImpl<Product, HazelcastProductService, ProductRepository> {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private HazelcastProductService cacheService;

	public ProductService(Logger logger) {
		super(logger);
	}

	@Override
	protected ProductRepository getRepository() {
		return repository;
	}

	@Override
	protected HazelcastProductService getCacheService() {
		return cacheService;
	}

	public List<Product> getProductsByStore(Long idStore) {
		return getRepository().getProductsByStore(idStore);
	}
}
