package br.sp.fair.fredericoalves.skipthedishes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import br.sp.fair.fredericoalves.skipthedishes.model.Order;

/**
 * Order Repository
 *
 * @author frederico.alves
 *
 */
@Repository
public interface OrderRepository extends BaseIdLongRepository<Order> {

	@EntityGraph(attributePaths = { "customer", "store" })
	List<Order> findAll();
}
