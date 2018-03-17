package br.sp.fair.fredericoalves.skipthedishes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sp.fair.fredericoalves.skipthedishes.model.Store;

/**
 * Store Repository
 *
 * @author frederico.alves
 *
 */
@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

}
