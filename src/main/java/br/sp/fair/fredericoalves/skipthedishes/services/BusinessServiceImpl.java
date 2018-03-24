package br.sp.fair.fredericoalves.skipthedishes.services;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;

import br.sp.fair.fredericoalves.skipthedishes.model.LongModel;
import br.sp.fair.fredericoalves.skipthedishes.repository.BaseIdLongRepository;

/**
 * Base Service
 *
 * @author frederico.alves
 *
 * @param <T>
 * @param <R>
 */
public abstract class BusinessServiceImpl<T extends LongModel, H extends HazelcastService<T>, R extends BaseIdLongRepository<T>> 
		implements BusinessService<T> {

	private Logger logger;

	protected BusinessServiceImpl(Logger logger) {
		this.logger = logger;
	}

	/*
	 * (non-Javadoc)
	 * @see br.sp.fair.fredericoalves.skipthedishes.services.BusinessService#save(br.sp.fair.fredericoalves.skipthedishes.model.LongModel)
	 */
	public T save(T entity) {
		beforeInsert();
		getCacheService().add(entity);
		afterInsert(entity);

		return entity;
	}

	/*
	 * (non-Javadoc)
	 * @see br.sp.fair.fredericoalves.skipthedishes.services.BusinessService#update(br.sp.fair.fredericoalves.skipthedishes.model.LongModel)
	 */
	public T update(T entity) {
		beforeUpdate();
		getCacheService().add(entity);
		afterUpdate(entity);

		return entity;
	}

	/*
	 * (non-Javadoc)
	 * @see br.sp.fair.fredericoalves.skipthedishes.services.BusinessService#delete(br.sp.fair.fredericoalves.skipthedishes.model.LongModel)
	 */
	public void delete(T entity) {
		beforeDelete();
		getCacheService().remove(entity.getId());
		afterDelete(entity);
	}

	/*
	 * (non-Javadoc)
	 * @see br.sp.fair.fredericoalves.skipthedishes.services.BusinessService#delete(java.lang.Long)
	 */
	public void delete(Long id) {
		beforeDelete();
		getCacheService().remove(id);
		afterDelete(id);
	}

	/*
	 * (non-Javadoc)
	 * @see br.sp.fair.fredericoalves.skipthedishes.services.BusinessService#findAll()
	 */
	public Collection<T> findAll() {
		if (getCacheService().list().isEmpty()) {
			for (Iterator<T> ite = getRepository().findAll().iterator(); ite.hasNext(); ) {
				getCacheService().add(ite.next());
				ite.remove();
			}
		}

		return getCacheService().list();
	}

	final Predicate<Long> notFound = i -> Objects.isNull(getCacheService().get(i));
	/*
	 * (non-Javadoc)
	 * @see br.sp.fair.fredericoalves.skipthedishes.services.BusinessService#findOne(java.lang.Long)
	 */
	public T findOne(Long id) {
		if (notFound.test(id)) {
			T data = getRepository().findOne(id);
			
			if (!Objects.isNull(data))
				getCacheService().add(data);
		}

		return getCacheService().get(id);
	}

	// It will be done by scheduler
	protected void afterInsert(T entity) {
		//getRepository().save(entity);
	}

	// It will be done by scheduler
	protected void afterUpdate(T entity) {
		//getRepository().save(entity);
	}

	protected void afterDelete(Long id) {
		getRepository().delete(id);
	}

	protected void afterDelete(T entity) {
		getRepository().delete(entity);
	}

	protected void beforeInsert() {
	}

	protected void beforeUpdate() {
	}

	protected void beforeDelete() {
	}

	/**
	 * Dispatch data into the database
	 * It is just an example for using cache to DB, but the better solution is using datagrid: JBoss DataGrid, Apache Ignite, etc...memcache...hotrod
	 */
	@Scheduled(fixedRate = 2000, initialDelay = 5000)
    protected void scheduleTaskDispatchDB() {
		logger.info("Storing data from cache to database...");

		final AtomicInteger count = new AtomicInteger(0);

        getCacheService().list().stream().forEach(d -> {
        	getRepository().save(d);
        	count.incrementAndGet();
        });

        logger.info("Number of data item stored into database: " + count.get());
    }

    /**
     * Default Repository
     *
     * @return
     */
    protected abstract R getRepository();

    /**
     * Cache Service
     *
     * @return
     */
	protected abstract H getCacheService();
}