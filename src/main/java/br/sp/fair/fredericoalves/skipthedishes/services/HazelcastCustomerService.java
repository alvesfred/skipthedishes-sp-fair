package br.sp.fair.fredericoalves.skipthedishes.services;

import org.springframework.stereotype.Service;

import br.sp.fair.fredericoalves.skipthedishes.model.Customer;

/**
 * Hazelcast Customer Service/Repo
 *
 * @author Frederico Cerqueira Alves
 * @see fredericocerqueiraalves@gmail.com
 */
@Service
public class HazelcastCustomerService extends HazelcastAbstractService<Customer> {

	@Override
	protected String getCacheListName() {
		return "customerList";
	}

	@Override
	protected String getCacheMapName() {
		return "customerMap";
	}

}
