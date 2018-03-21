package br.sp.fair.fredericoalves.skipthedishes.resources;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sp.fair.fredericoalves.skipthedishes.model.Store;
import br.sp.fair.fredericoalves.skipthedishes.services.StoreService;

/**
 * Store Controller
 *
 * @author frederico.alves
 *
 */
@RestController
@RequestMapping("/api/v1/store")
public class StoreController extends ControllerDefault<Store, StoreService> { 

	@GetMapping("/list")
	public Collection<Store> get() {
		return super.get();
	}

	@GetMapping("/get/{id}")
	public Store get(@PathVariable Long id) {
		return super.get(id);
	}
}
