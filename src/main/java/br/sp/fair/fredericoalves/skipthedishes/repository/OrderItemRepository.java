package br.sp.fair.fredericoalves.skipthedishes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.sp.fair.fredericoalves.skipthedishes.model.OrderItem;

/**
 * Order Item Repository
 *
 * @author frederico.alves
 *
 */
@Repository
@Component
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	
}
