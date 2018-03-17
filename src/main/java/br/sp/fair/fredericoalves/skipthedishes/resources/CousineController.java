package br.sp.fair.fredericoalves.skipthedishes.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sp.fair.fredericoalves.skipthedishes.model.Store;
import br.sp.fair.fredericoalves.skipthedishes.services.ProductService;
import br.sp.fair.fredericoalves.skipthedishes.services.StoreService;

/**
 * Cousine Controller
 *
 * @author frederico.alves
 *
 */
@RestController
@RequestMapping("/api/v1/cousine")
public class CousineController {

	@Autowired
	protected ProductService prodService;

	@Autowired
	protected StoreService storeService;

	@SuppressWarnings("rawtypes")
	@GetMapping("/")
	public ResponseEntity get() {
		return ResponseEntity.ok().build();
	}

	@GetMapping("/search/{searchTex}")
	public Store get(@PathVariable Long searchTex) {
		// TODO
		//return storeService.findOne(id);
		return null;
	}

	@GetMapping("/{cousineId}/stores")
	public Store getStores(@PathVariable Long cousineId) {
		// TODO
		//return storeService.findOne(id);
		return null;
	}
}
