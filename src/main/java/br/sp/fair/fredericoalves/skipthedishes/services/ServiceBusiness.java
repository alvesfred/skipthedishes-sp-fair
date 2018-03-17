package br.sp.fair.fredericoalves.skipthedishes.services;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Scheduled;

import br.sp.fair.fredericoalves.skipthedishes.model.Model;

/**
 * Base Service
 *
 * @author frederico.alves
 *
 * @param <T>
 * @param <R>
 */
public abstract class ServiceBusiness<S extends HazelcastService<T>, T extends Model, R extends CrudRepository<T, Long>> {

    private static final Logger logger = LoggerFactory.getLogger(ServiceBusiness.class);

	@Autowired
	protected R repository;

	@Autowired
	private S cacheService;

	public T save(T entity) {
		beforeInsert();
		getCacheService().add(entity);
		afterInsert(entity);

		return entity;
	}

	public T update(T entity) {
		beforeUpdate();
		getCacheService().add(entity);
		afterUpdate(entity);

		return entity;
	}

	public void delete(T entity) {
		beforeDelete();
		getCacheService().remove(entity.getId());
		afterDelete(entity);
	}

	public void delete(Long id) {
		beforeDelete();
		getCacheService().remove(id);
		afterDelete(id);
	}

	public Collection<T> findAll() {
		if (getCacheService().list().isEmpty()) {
			for (Iterator<T> ite = repository.findAll().iterator(); ite.hasNext(); ) {
				getCacheService().add(ite.next());
			}
		}

		return cacheService.list();
	}

	final Predicate<Long> notFound = i -> Objects.isNull(getCacheService().get(i));
	public T findOne(Long id) {
		if (notFound.test(id)) {
			T data = repository.findOne(id);
			
			if (!Objects.isNull(data))
				getCacheService().add(data);
		}

		return getCacheService().get(id);
	}

	// It will be done by scheduler
	protected void afterInsert(T entity) {
		//repository.save(entity);
	}

	// It will be done by scheduler
	protected void afterUpdate(T entity) {
		//repository.save(entity);
	}

	protected void afterDelete(Long id) {
		repository.delete(id);
	}

	protected void afterDelete(T entity) {
		repository.delete(entity);
	}

	protected void beforeInsert() {
		 logger.info("before insert...");
	}

	protected void beforeUpdate() {
		logger.info("before update...");
	}

	protected void beforeDelete() {
		logger.info("before delete...");
	}

	/**
	 * Going to the database
	 * It is just an example for using cache to DB, but the better solution is using datagrid: JBoss DataGrid, Apache Ignite, etc...memcache...hotrod
	 */
    @Scheduled(fixedRate = 2000, initialDelay = 5000)
    public void scheduleTaskDispatchDB() {
        logger.info("Fixed Rate Task - Dispatch...");
        getCacheService().list().forEach(d -> {
        	repository.save(d);
        });
    }
 
	/**
	 * Service Cache
	 * @return
	 */
	protected S getCacheService() {
		return cacheService;
	}
}