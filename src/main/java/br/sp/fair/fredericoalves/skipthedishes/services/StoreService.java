package br.sp.fair.fredericoalves.skipthedishes.services;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.sp.fair.fredericoalves.skipthedishes.model.Store;
import br.sp.fair.fredericoalves.skipthedishes.repository.StoreRepository;

/**
 * Store Service
 *
 * @author frederico.alves
 *
 */
@Service
public class StoreService extends BusinessServiceImpl<Store, HazelcastStoreService, StoreRepository> {

	@Autowired
	@Qualifier("storeRepository")
	private StoreRepository storeRepository;

	@Autowired
	private HazelcastStoreService cacheService;

	public StoreService(Logger logger) {
		super(logger);
	}

	@Override
	protected StoreRepository getRepository() {
		return storeRepository;
	}

	@Override
	protected HazelcastStoreService getCacheService() {
		return cacheService;
	}

	public Store search(String searchTex) {
		return storeRepository.searchByNameSearch(searchTex);
	}
}
