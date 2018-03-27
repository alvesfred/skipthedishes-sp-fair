package br.sp.fair.fredericoalves.skipthedishes;

import org.springframework.beans.factory.annotation.Autowired;

import br.sp.fair.fredericoalves.skipthedishes.model.Store;
import br.sp.fair.fredericoalves.skipthedishes.repository.StoreRepository;

/**
 * Cousine Service Test
 */
public class CousineServiceTest extends BaseTest<Store, StoreRepository> {

	@Autowired
    private StoreRepository storeRepository;

	@Override
	protected StoreRepository getRepository() {
		return storeRepository;
	}
}
