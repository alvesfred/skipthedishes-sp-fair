package br.sp.fair.fredericoalves.skipthedishes.services;

import java.util.List;

import br.sp.fair.fredericoalves.skipthedishes.model.Model;

/**
 * Hazelcast Default Service
 *
 * @author Frederico Cerqueira Alves
 * @see fredericocerqueiraalves@gmail.com
 */
public interface HazelcastService<T extends Model> {

	/**
	 * Get
	 *
	 * @param id
	 * @return
	 */
    public T get(Long id);

    /**
     * Remove
     *
     * @param id
     */
    public void remove(Long id);

    /**
     * Add
     *
     * @param entity
     */
    public void add(T entity);

    /**
     * List
     *
     * @return
     */
    public List<T> list();

    /**
     * Add List
     *
     * @param list
     */
    public void addList(List<T> list);

    /**
     * Remove List
     */
    public void removeList();

}
