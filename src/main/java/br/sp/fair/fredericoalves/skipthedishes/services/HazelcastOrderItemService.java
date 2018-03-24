package br.sp.fair.fredericoalves.skipthedishes.services;

import org.springframework.stereotype.Service;

import br.sp.fair.fredericoalves.skipthedishes.model.OrderItem;

/**
 * Hazelcast Order Item Service/Repo
 *
 * @author Frederico Cerqueira Alves
 * @see fredericocerqueiraalves@gmail.com
 */
@Service
public class HazelcastOrderItemService extends HazelcastAbstractService<OrderItem> {

	@Override
	protected String getCacheListName() {
		return "orderItemList";
	}

	@Override
	protected String getCacheMapName() {
		return "orderItemMap";
	}

}
