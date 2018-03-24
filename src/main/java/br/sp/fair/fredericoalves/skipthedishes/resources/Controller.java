package br.sp.fair.fredericoalves.skipthedishes.resources;

import java.util.Collection;

import br.sp.fair.fredericoalves.skipthedishes.model.LongModel;

/**
 * Controller (Base Resource)
 * 
 * @author frederico.alves
 *
 * @param <T>
 */
public interface Controller<T extends LongModel> {

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
	Collection<T> get();

	/**
	 * Find one by id
	 *
	 * @param id
	 * @return
	 */
	T get(Long id);
}
