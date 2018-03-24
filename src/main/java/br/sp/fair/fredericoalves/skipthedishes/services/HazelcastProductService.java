package br.sp.fair.fredericoalves.skipthedishes.services;

import org.springframework.stereotype.Service;

import br.sp.fair.fredericoalves.skipthedishes.model.Product;

/**
 * Hazelcast Product Service/Repo
 *
 * @author Frederico Cerqueira Alves
 * @see fredericocerqueiraalves@gmail.com
 */
@Service
public class HazelcastProductService extends HazelcastAbstractService<Product> {

	@Override
	protected String getCacheListName() {
		return "productList";
	}

	@Override
	protected String getCacheMapName() {
		return "productMap";
	}

}
