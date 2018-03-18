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

import br.sp.fair.fredericoalves.skipthedishes.auth.Token;
import br.sp.fair.fredericoalves.skipthedishes.model.Customer;
import br.sp.fair.fredericoalves.skipthedishes.services.CustomerService;

/**
 * Customer Controller
 *
 * @author frederico.alves
 *
 */
@RestController
@RequestMapping("/api/v1/customer")
// FIXME
//public class CustomerController extends ControllerDefault<Customer, CustomerService> {
public class CustomerController {

	@Autowired
	private CustomerService service;

    @PostMapping(path = "/auth", produces = "application/json;charset=UTF-8")
	public Token auth() throws Exception {
		return new Token(); // TODO Auth Service on parent service
	}	

    @PostMapping(path = "/save", produces = "application/json;charset=UTF-8")
	public Customer save(@RequestBody @Valid Customer entity) {
		return service.save(entity);
	}

	@GetMapping("/list")
	public Collection<Customer> get() {
		return service.findAll();
	}

	@GetMapping("/get/{id}")
	public Customer get(@PathVariable Long id) {
		return service.findOne(id);
	}
}
