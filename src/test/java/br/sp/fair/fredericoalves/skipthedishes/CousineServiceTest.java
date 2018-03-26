package br.sp.fair.fredericoalves.skipthedishes;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.sp.fair.fredericoalves.skipthedishes.model.Store;
import br.sp.fair.fredericoalves.skipthedishes.repository.StoreRepository;

/**
 * Cousine Service Test
 */
public class CousineServiceTest extends BaseTest<Store, StoreRepository> {

	@Autowired
    private StoreRepository storeRepository;

    public CousineServiceTest() {
		super(LoggerFactory.getLogger(CousineServiceTest.class));
	}

	@Override
	protected StoreRepository getRepository() {
		return storeRepository;
	}
}
