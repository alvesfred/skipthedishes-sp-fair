package br.sp.fair.fredericoalves.skipthedishes.services;

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
public class CustomerService extends ServiceBusiness<HazelcastCustomerService, Customer, CustomerRepository> {

	// TODO apply hazelcast services here...
}
