package br.sp.fair.fredericoalves.skipthedishes.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.sp.fair.fredericoalves.skipthedishes.model.Model;

/**
 * Base Repository
 *
 * @author frederico.alves
 *
 */
public interface BaseIdLongRepository<T extends Model> extends PagingAndSortingRepository<T, Long> {

}
