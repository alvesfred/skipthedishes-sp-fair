package br.sp.fair.fredericoalves.skipthedishes.repository;

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

}
