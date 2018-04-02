package br.sp.fair.fredericoalves.skipthedishes.services;

import java.util.List;

import org.slf4j.Logger;
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

	public OrderItemService(Logger logger) {
		super(logger);
	}

	public List<OrderItem> getOrderItemsFromOrder(Long idOrder) {
		return getRepository().findOrderItemsFromOrder(idOrder);
	}

	@Override
	protected OrderItemRepository getRepository() {
		return repository;
	}

	@Override
	protected HazelcastOrderItemService getCacheService() {
		return cacheService;
	}

}
