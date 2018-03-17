package br.sp.fair.fredericoalves.skipthedishes.services;

import org.springframework.stereotype.Repository;

import br.sp.fair.fredericoalves.skipthedishes.model.Product;
import br.sp.fair.fredericoalves.skipthedishes.repository.ProductRepository;

/**
 * Product Service
 *
 * @author frederico.alves
 *
 */
@Repository
public class ProductService extends ServiceBusiness<HazelcastProductService, Product, ProductRepository> {

}
