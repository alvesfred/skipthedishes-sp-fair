package br.sp.fair.fredericoalves.skipthedishes;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.json.JSONException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import br.sp.fair.fredericoalves.skipthedishes.model.Store;
import br.sp.fair.fredericoalves.skipthedishes.repository.StoreRepository;

/**
 * Cousine Service Test
 */
//@SpringBootTest(classes = { CousineController.class })
public class CousineServiceTest extends BaseTest<Store, StoreRepository> {

	@Autowired
    private StoreRepository storeRepository;

	@Override
	protected StoreRepository getRepository() {
		return storeRepository;
	}

	@Test
	public void testCousineIT() throws JSONException {
		HttpEntity<String> entity = new HttpEntity<String>(null, getHttpHeaders());

		ResponseEntity<String> response = restTemplate.exchange(
				funcURI.apply("/api/v1/cousine/get"),
				HttpMethod.GET, entity, String.class);

		logger.info(response.getBody());
		assertNotNull(response.getBody());
	}

	@Test
	public void testFindStore1LIT() throws JSONException {
		Store store = new Store();
		store.setId(1L);

		HttpEntity<Long> entity = new HttpEntity<Long>(store.getId(), getHttpHeaders());

		ResponseEntity<String> response = restTemplate.exchange(
				funcURI.apply("/api/v1/cousine/find"),
				HttpMethod.POST, entity, String.class);

		assertNotNull(response.getBody());
		logger.info(response.getBody());

		//String expected = "{id:1,name:Store 01,address:Address 01 Test,pk:1}";
		//JSONAssert.assertEquals(expected, response.getBody(), false);
		assertTrue(response.getBody().contains("id") && response.getBody().contains("name"));
	}
}
