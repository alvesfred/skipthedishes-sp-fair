package br.sp.fair.fredericoalves.skipthedishes.services;

import org.springframework.stereotype.Service;

import br.sp.fair.fredericoalves.skipthedishes.model.Store;
import br.sp.fair.fredericoalves.skipthedishes.repository.StoreRepository;

/**
 * Store Service
 *
 * @author frederico.alves
 *
 */
@Service
public class StoreService extends ServiceDefault<HazelcastStoreService, Store, StoreRepository> {

}
