package br.sp.fair.fredericoalves.skipthedishes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import br.sp.fair.fredericoalves.skipthedishes.model.OrderItem;

/**
 * Order Item Repository
 *
 * @author frederico.alves
 *
 */
@Repository
public interface OrderItemRepository extends BaseIdLongRepository<OrderItem> {

	@EntityGraph(attributePaths = { "product", "order" })
	List<OrderItem> findAll();
}
