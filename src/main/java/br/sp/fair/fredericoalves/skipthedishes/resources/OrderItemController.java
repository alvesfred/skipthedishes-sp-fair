package br.sp.fair.fredericoalves.skipthedishes.resources;

import java.util.Collection;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sp.fair.fredericoalves.skipthedishes.model.Order;
import br.sp.fair.fredericoalves.skipthedishes.model.OrderItem;
import br.sp.fair.fredericoalves.skipthedishes.services.OrderItemService;
import br.sp.fair.fredericoalves.skipthedishes.services.OrderService;

/**
 * Order Items Controller
 *
 * @author frederico.alves
 *
 */
@RestController
@RequestMapping("/api/v1/order")
public class OrderItemController extends ControllerDefault<OrderItem, OrderItemService> {

	@Autowired
	protected OrderItemService serviceBus;

	@Autowired
	//@Qualifier("orderItemService")
	protected OrderService serviceOrder;

	public OrderItemController(Logger logger) {
		super(logger);
	}

	@GetMapping("/list")
	public Collection<OrderItem> get() {
		Collection<OrderItem> orders = super.get();
		return orders;
	}

	@GetMapping("/get/{id}")
	public OrderItem get(@PathVariable Long id) {
		return super.get(id);
	}

	@GetMapping("/{orderItemId}/order")
	public Order getOrderFromOrderItem(@PathVariable Long orderItemId) {
		return serviceBus.findOne(orderItemId).getOrder();
	}

	@Override
	protected OrderItemService getServiceBus() {
		return serviceBus;
	}

	protected OrderService getServiceItemOrder() {
		return serviceOrder;
	}

}
