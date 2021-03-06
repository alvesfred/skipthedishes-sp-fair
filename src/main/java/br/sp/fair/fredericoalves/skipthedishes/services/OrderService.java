package br.sp.fair.fredericoalves.skipthedishes.services;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private OrderRepository repository;

	@Autowired
	private HazelcastOrderService cacheService;

	public OrderService(Logger logger) {
		super(logger);
	}

	@Override
	protected OrderRepository getRepository() {
		return repository;
	}

	@Override
	protected HazelcastOrderService getCacheService() {
		return cacheService;
	}
}
