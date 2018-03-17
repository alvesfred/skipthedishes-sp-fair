package br.sp.fair.fredericoalves.skipthedishes.services;

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
public class OrderItemService extends ServiceBusiness<HazelcastOrderItemService, OrderItem, OrderItemRepository> {

}
