package br.sp.fair.fredericoalves.skipthedishes.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sp.fair.fredericoalves.skipthedishes.model.Product;
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

	@GetMapping("/search/{searchTex}")
	public Store search(@PathVariable String searchTex) {
		// looking for stores that have the same name pattern on searching
		return serviceBus.search(searchTex);
	}

	@GetMapping("/{cousineId}/products")
	public List<Product> getStoreWithProducts(@PathVariable Long cousineId) {
		Store store = super.get(cousineId);

		if (!Objects.isNull(store))
			return store.getItems();

		return new ArrayList<>();
	}

	@Override
	protected StoreService getServiceBus() {
		return serviceBus;
	}
}
