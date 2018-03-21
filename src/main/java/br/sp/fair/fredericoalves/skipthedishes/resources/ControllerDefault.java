package br.sp.fair.fredericoalves.skipthedishes.resources;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.sp.fair.fredericoalves.skipthedishes.model.Model;
import br.sp.fair.fredericoalves.skipthedishes.services.BusinessService;

/**
 * Base Resource Controller
 *
 * @author frederico.alves
 *
 * @param <T>
 * @param <S>
 */
public abstract class ControllerDefault<T extends Model, S extends BusinessService<T>> 
		implements Controller<T> {

	@Autowired
	S serviceBus;

	@PostMapping("/save")
	public T save(@RequestBody @Valid T entity) {
		return serviceBus.save(entity);
	}

	@PutMapping("/update")
	public T update(@RequestBody T entity) {
		return serviceBus.update(entity);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		serviceBus.delete(id);
	}

	@GetMapping("/get")
	public Collection<T> get() {
		return serviceBus.findAll();
	}

	@GetMapping("/find/{id}")
	public T get(@PathVariable Long id) {
		return serviceBus.findOne(id);
	}

}