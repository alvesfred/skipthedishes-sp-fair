package br.sp.fair.fredericoalves.skipthedishes.services;

import org.springframework.stereotype.Repository;

import br.sp.fair.fredericoalves.skipthedishes.model.Store;

/**
 * Hazelcast Store Service/Repo
 *
 * @author Frederico Cerqueira Alves
 * @see fredericocerqueiraalves@gmail.com
 */
@Repository("hazelcastStoreService")
public class HazelcastStoreService extends HazelcastAbstractService<Store> {

	@Override
	protected String getCacheListName() {
		return "storeList";
	}

	@Override
	protected String getCacheMapName() {
		return "storeMap";
	}

}
