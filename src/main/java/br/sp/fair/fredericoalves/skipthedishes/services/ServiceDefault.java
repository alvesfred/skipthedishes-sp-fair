package br.sp.fair.fredericoalves.skipthedishes.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import br.sp.fair.fredericoalves.skipthedishes.model.Model;

/**
 * Base Service
 *
 * @author frederico.alves
 *
 * @param <T>
 * @param <R>
 */
public abstract class ServiceDefault<S extends HazelcastService<T>, T extends Model, R extends JpaRepository<T, Long>> {

	@Autowired
	protected R repository;

	@Autowired
	private S cacheService;

	public T save(T entity) {
		if (entity.getId() != null) {
			return update(entity);
		}
		beforeInsert();
		repository.save(entity);
		afterInsert();
		return entity;
	}

	public T update(T entity) {
		beforeUpdate();
		repository.save(entity);
		afterUpdate();
		return entity;
	}

	public void delete(T entity) {
		beforeDelete();
		repository.delete(entity);
		afterDelete();
	}

	public void delete(Long id) {
		beforeDelete();
		repository.delete(id);
		afterDelete();
	}

	public Collection<T> findAll() {
		return repository.findAll();
	}

	public T findOne(Long id) {
		return repository.findOne(id);
	}

	protected void afterInsert() {
		
	}

	protected void afterUpdate() {
		
	}

	protected void afterDelete() {
		
	}

	protected void beforeInsert() {
		
	}

	protected void beforeUpdate() {
		
	}

	protected void beforeDelete() {
		
	}

	/**
	 * Service Cache
	 * @return
	 */
	protected S getCacheService() {
		return cacheService;
	}
}