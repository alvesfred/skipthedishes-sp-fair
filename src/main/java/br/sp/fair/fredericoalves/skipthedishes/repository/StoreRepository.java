package br.sp.fair.fredericoalves.skipthedishes.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.sp.fair.fredericoalves.skipthedishes.model.Store;

/**
 * Store Repository
 *
 * @author frederico.alves
 *
 */
@Repository
public interface StoreRepository extends BaseIdLongRepository<Store> {

	/**
	 * Search by name with a name liked pattern
	 *
	 * @param searchTex
	 * @return
	 */
	@Query("select s from Store s where s.name like %?1%")
	Store searchByNameSearch(String searchTex);

}
