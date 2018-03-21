package br.sp.fair.fredericoalves.skipthedishes.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.sp.fair.fredericoalves.skipthedishes.model.Customer;

/**
 * Customer Repository
 *
 * @author Frederico Cerqueira Alves
 * @see fredericocerqueiraalves@gmail.com
 *
 */
@Repository
@Component
public interface CustomerRepository extends BaseIdLongRepository<Customer> {

}
