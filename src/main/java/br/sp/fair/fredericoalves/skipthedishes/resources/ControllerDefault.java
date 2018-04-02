package br.sp.fair.fredericoalves.skipthedishes.resources;

import java.util.Collection;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.sp.fair.fredericoalves.skipthedishes.model.LongModel;
import br.sp.fair.fredericoalves.skipthedishes.services.BusinessService;

/**
 * Base Resource Controller
 *
 * @author frederico.alves
 *
 * @param <T>
 * @param <S>
 */
public abstract class ControllerDefault<T extends LongModel, S extends BusinessService<T>> 
		implements Controller<T> {

	protected final Logger logger;

	public ControllerDefault() {
		this.logger = LoggerFactory.getLogger(getClass().getName());
	}

	public ControllerDefault(Logger logger) {
		this.logger = logger;
	}
	
	@PostMapping("/save")
	public T save(@RequestBody @Valid T entity) {
		return getServiceBus().save(entity);
	}

	@PutMapping("/update")
	public T update(@RequestBody T entity) {
		return getServiceBus().update(entity);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		getServiceBus().delete(id);
	}

	@GetMapping("/get")
	public Collection<T> get() {
		return getServiceBus().findAll();
	}

	@GetMapping("/find/{id}")
	public T get(@PathVariable Long id) {
		return getServiceBus().findOne(id);
	}

	/**
	 * Service Default
	 *
	 * @return
	 */
	protected abstract S getServiceBus();
}