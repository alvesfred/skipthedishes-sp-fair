package br.sp.fair.fredericoalves.skipthedishes.resources;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sp.fair.fredericoalves.skipthedishes.model.Store;
import br.sp.fair.fredericoalves.skipthedishes.services.StoreService;

/**
 * Cousine Controller
 *
 * @author frederico.alves
 *
 */
@RestController
@RequestMapping("/api/v1/cousine")
public class CousineController extends ControllerDefault<Store, StoreService> {

	@Autowired
	protected StoreService serviceBus;

	public CousineController(Logger logger) {
		super(logger);
	}

	@SuppressWarnings("rawtypes")
	@GetMapping("/")
	public ResponseEntity info() {
		return ResponseEntity.ok().build();
	}

	// Warning whenever execution is over 3 sec
	@GetMapping("/search/{searchTex}")
	public Store search(@PathVariable String searchTex) {
		// TODO get with search of a specific store name
		return null;
	}

	@GetMapping("/{cousineId}/products")
	public Store getStoreWithProducts(@PathVariable Long cousineId) {
		return super.get(cousineId);
	}

	@Override
	protected StoreService getServiceBus() {
		return serviceBus;
	}
}
