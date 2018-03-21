package br.sp.fair.fredericoalves.skipthedishes.services;

import java.util.Collection;

import br.sp.fair.fredericoalves.skipthedishes.model.Model;

/**
 * Service Base Business
 *
 * @author frederico.alves
 *
 * @param <T>
 */
public interface BusinessService<T extends Model> {
	/**
	 * Save/Persist
	 *
	 * @param entity
	 * @return
	 */
	T save(T entity);

	/**
	 * Update
	 *
	 * @param entity
	 * @return
	 */
	T update(T entity);

	/**
	 * Delete
	 *
	 * @param entity
	 */
	void delete(T entity);

	/**
	 * Delete by id
	 *
	 * @param id
	 */
	void delete(Long id);

	/**
	 * FindAll
	 *
	 * @return
	 */
	Collection<T> findAll();

	/**
	 * Find one by id
	 *
	 * @param id
	 * @return
	 */
	T findOne(Long id);
}
