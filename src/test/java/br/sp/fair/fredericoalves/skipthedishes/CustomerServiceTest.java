package br.sp.fair.fredericoalves.skipthedishes;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.sp.fair.fredericoalves.skipthedishes.model.Customer;
import br.sp.fair.fredericoalves.skipthedishes.repository.CustomerRepository;

/**
 * Customer Service Test
 */
public class CustomerServiceTest extends BaseTest<Customer, CustomerRepository> {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerServiceTest() {
		super(LoggerFactory.getLogger(CustomerServiceTest.class));
	}

	@Override
	protected CustomerRepository getRepository() {
		return customerRepository;
	}
   
}
