package br.sp.fair.fredericoalves.skipthedishes.services;

import org.springframework.stereotype.Repository;

import br.sp.fair.fredericoalves.skipthedishes.model.Order;

/**
 * Hazelcast Order Service/Repo
 *
 * @author Frederico Cerqueira Alves
 * @see fredericocerqueiraalves@gmail.com
 */
@Repository("hazelcastOrderService")
public class HazelcastOrderService extends HazelcastAbstractService<Order> {

    public HazelcastOrderService() {
    }

	@Override
	protected String getCacheListName() {
		return "orderList";
	}

	@Override
	protected String getCacheMapName() {
		return "orderMap";
	}

}
