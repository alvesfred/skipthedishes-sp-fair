package br.sp.fair.fredericoalves.skipthedishes.resources;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sp.fair.fredericoalves.skipthedishes.model.Order;
import br.sp.fair.fredericoalves.skipthedishes.services.OrderService;

/**
 * Order Controller
 *
 * @author frederico.alves
 *
 */
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {//extends ControllerDefault<Order, OrderService> {

	@Autowired
	protected OrderService service;

	@GetMapping("/list")
	public Collection<Order> get() {
		return service.findAll();
	}

	@GetMapping("/get/{id}")
	public Order get(@PathVariable Long id) {
		return service.findOne(id);
	}
}
