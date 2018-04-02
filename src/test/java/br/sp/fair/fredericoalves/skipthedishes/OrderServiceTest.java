package br.sp.fair.fredericoalves.skipthedishes;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.sp.fair.fredericoalves.skipthedishes.model.OrderItem;
import br.sp.fair.fredericoalves.skipthedishes.repository.OrderItemRepository;
import br.sp.fair.fredericoalves.skipthedishes.repository.OrderRepository;

/**
 * Order Service Test
 */
public class OrderServiceTest extends BaseTest<OrderItem, OrderItemRepository> {

	@Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testListOrders() {
    	logger.info("Finding all orders...");
    	assertNotNull(orderRepository.findAll());
    }

	@Override
	protected OrderItemRepository getRepository() {
		return orderItemRepository;
	}
}
