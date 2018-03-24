package br.sp.fair.fredericoalves.skipthedishes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sp.fair.fredericoalves.skipthedishes.model.Customer;
import br.sp.fair.fredericoalves.skipthedishes.repository.CustomerRepository;

/**
 * Base Customer Implementation
 *
 * @author frederico.alves
 *
 */
@Service
public class CustomerService extends BusinessServiceImpl<Customer, HazelcastCustomerService, CustomerRepository> {

	@Autowired
	//@Qualifier("customerRepository")
	private CustomerRepository repository;

	@Autowired
	private HazelcastCustomerService cacheService;

	@Override
	protected CustomerRepository getRepository() {
		return repository;
	}

	@Override
	protected HazelcastCustomerService getCacheService() {
		return cacheService;
	}
}
