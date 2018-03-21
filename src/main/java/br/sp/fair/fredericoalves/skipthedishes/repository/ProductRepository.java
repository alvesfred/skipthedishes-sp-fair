package br.sp.fair.fredericoalves.skipthedishes.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.sp.fair.fredericoalves.skipthedishes.model.Product;

/**
 * Product Repository
 *
 * @author frederico.alves
 *
 */
@Repository
@Component
public interface ProductRepository extends BaseIdLongRepository<Product> {

}
