package br.sp.fair.fredericoalves.skipthedishes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.sp.fair.fredericoalves.skipthedishes.model.Product;

/**
 * Product Repository
 *
 * @author frederico.alves
 *
 */
@Repository
public interface ProductRepository extends BaseIdLongRepository<Product> {

	@Query("select p from Product p where p.store.id = ?1")
	List<Product> getProductsByStore(Long idStore);

}
