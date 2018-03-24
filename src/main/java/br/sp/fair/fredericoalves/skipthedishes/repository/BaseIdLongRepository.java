package br.sp.fair.fredericoalves.skipthedishes.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.sp.fair.fredericoalves.skipthedishes.model.LongModel;

/**
 * Base Repository with paging
 *
 * @author frederico.alves
 *
 */
public interface BaseIdLongRepository<T extends LongModel> extends PagingAndSortingRepository<T, Long> {
//public interface BaseIdLongRepository<T extends LongModel> extends JpaRepository<T, Long> {
}
