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
 * Order Controller
 *
 * @author frederico.alves
 *
 */
@RestController
@RequestMapping("/api/v1/order")
public class OrderController extends ControllerDefault<Order, OrderService> {

	@Autowired
	protected OrderItemService orderItemService;

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
		OrderItem i = orderItemService.save(item);
		return i.getOrder();
	}

	@GetMapping("/orders")
	public List<OrderItem> getOrderItems(@PathVariable OrderItem item) {
		return orderItemService.findAll().stream().collect(Collectors.toList());
	}

}
