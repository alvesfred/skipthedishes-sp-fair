package br.sp.fair.fredericoalves.skipthedishes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sp.fair.fredericoalves.skipthedishes.model.OrderItem;
import br.sp.fair.fredericoalves.skipthedishes.repository.OrderItemRepository;

/**
 * Order Item Service
 *
 * @author frederico.alves
 *
 */
@Service
public class OrderItemService extends BusinessServiceImpl<OrderItem, HazelcastOrderItemService, OrderItemRepository> {

	@Autowired
	private OrderItemRepository repository;

	@Autowired
	private HazelcastOrderItemService cacheService;

	@Override
	protected OrderItemRepository getRepository() {
		return repository;
	}

	@Override
	protected HazelcastOrderItemService getCacheService() {
		return cacheService;
	}

}
