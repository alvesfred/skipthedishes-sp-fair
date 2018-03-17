package br.sp.fair.fredericoalves.skipthedishes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.sp.fair.fredericoalves.skipthedishes.model.Order;

/**
 * Order Repository
 *
 * @author frederico.alves
 *
 */
@Repository
@Component
public interface OrderRepository extends JpaRepository<Order, Long> {

	@EntityGraph(attributePaths = { "customer", "store" })
	public List<Order> findAll();
}
