package br.sp.fair.fredericoalves.skipthedishes.resources;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sp.fair.fredericoalves.skipthedishes.model.Customer;
import br.sp.fair.fredericoalves.skipthedishes.security.Token;
import br.sp.fair.fredericoalves.skipthedishes.services.CustomerService;

/**
 * Customer Controller
 *
 * @author frederico.alves
 *
 */
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController extends ControllerDefault<Customer, CustomerService> {

	@Autowired
	private CustomerService serviceBus;

    @PostMapping(path = "/auth", produces = "application/json;charset=UTF-8")
	public Token auth() throws Exception {
    	// FIXME
		return new Token(); // TODO Auth Service Listener
	}	

    @PostMapping(path = "/save", produces = "application/json;charset=UTF-8")
	public Customer save(@RequestBody @Valid Customer entity) {
		return super.save(entity);
	}

	@GetMapping("/list")
	public Collection<Customer> get() {
		return super.get();
	}

	@GetMapping("/get/{id}")
	public Customer get(@PathVariable Long id) {
		return super.get(id);
	}

	@Override
	protected CustomerService getServiceBus() {
		return serviceBus;
	}
}
