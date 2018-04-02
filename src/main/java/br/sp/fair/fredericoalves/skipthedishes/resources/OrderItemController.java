package br.sp.fair.fredericoalves.skipthedishes.resources;

import java.util.Collection;
import java.util.List;

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
import br.sp.fair.fredericoalves.skipthedishes.util.StreamMapOptionalUtil;

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
	protected OrderItemService serviceOrderItems;

	public OrderItemController(Logger logger) {
		super(logger);
	}

	@GetMapping("/list")
	public Collection<Order> get() {
		return super.get();
	}

	@GetMapping("/listOrderItems")
	public Collection<OrderItem> listOrderItems() {
		return serviceOrderItems.findAll();
	}

	@GetMapping("/get/{id}")
	public Order get(@PathVariable Long id) {
		return super.get(id);
	}

	@GetMapping("/getOrderFromItem/{orderItemId}/")
	public Order getOrderFromOrderItem(@PathVariable Long orderItemId) {
		return StreamMapOptionalUtil.resolve(id -> getServiceItemOrder().findOne(id), orderItemId).get().getOrder();
	}

	@GetMapping("/getOrderItems/{idOrder}")
	public List<OrderItem> getOrderItemsFromOrder(@PathVariable Long idOrder) {
		return StreamMapOptionalUtil.resolve(id -> getServiceItemOrder().getOrderItemsFromOrder(idOrder), idOrder).get();
	}

	@Override
	protected OrderService getServiceBus() {
		return serviceBus;
	}

	protected OrderItemService getServiceItemOrder() {
		return serviceOrderItems;
	}

}
