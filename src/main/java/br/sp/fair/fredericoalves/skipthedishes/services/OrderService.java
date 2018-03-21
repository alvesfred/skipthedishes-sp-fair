package br.sp.fair.fredericoalves.skipthedishes.services;

import org.springframework.stereotype.Service;

import br.sp.fair.fredericoalves.skipthedishes.model.Order;
import br.sp.fair.fredericoalves.skipthedishes.repository.OrderRepository;

/**
 * Order Service
 *
 * @author frederico.alves
 *
 */
@Service
public class OrderService extends BusinessServiceImpl<Order, HazelcastOrderService, OrderRepository> {

}
