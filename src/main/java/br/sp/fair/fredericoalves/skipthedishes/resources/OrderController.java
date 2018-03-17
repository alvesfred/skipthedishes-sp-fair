package br.sp.fair.fredericoalves.skipthedishes.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	
}
