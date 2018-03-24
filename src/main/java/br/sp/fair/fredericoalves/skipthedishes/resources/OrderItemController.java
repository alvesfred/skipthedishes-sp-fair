package br.sp.fair.fredericoalves.skipthedishes.resources;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
public class OrderItemController extends ControllerDefault<Order, OrderService> {

	@Autowired
	protected OrderService serviceBus;

	@Autowired
	protected OrderItemService serviceOrderItem;

	@GetMapping("/list")
	public Collection<Order> get() {
		return super.get();
	}

	@GetMapping("/get/{id}")
	public Order get(@PathVariable Long id) {
		return super.get(id);
	}

	@PostMapping("/save")
	public Order get(@PathVariable OrderItem item) {
		OrderItem i = getServiceItemOrder().save(item);

		return i.getOrder();
	}

	@GetMapping("/orders")
	public List<OrderItem> getOrderItems(@PathVariable OrderItem item) {
		return serviceOrderItem.findAll().stream().collect(Collectors.toList());
	}

	@Override
	protected OrderService getServiceBus() {
		return serviceBus;
	}

	protected OrderItemService getServiceItemOrder() {
		return serviceOrderItem;
	}

}
