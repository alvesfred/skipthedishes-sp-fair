package br.sp.fair.fredericoalves.skipthedishes.services;

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

	@Override
	protected ProductRepository getRepository() {
		return repository;
	}

	@Override
	protected HazelcastProductService getCacheService() {
		return cacheService;
	}

}
