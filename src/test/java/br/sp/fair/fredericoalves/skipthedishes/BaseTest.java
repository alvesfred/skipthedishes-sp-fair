package br.sp.fair.fredericoalves.skipthedishes;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.sp.fair.fredericoalves.skipthedishes.model.LongModel;
import br.sp.fair.fredericoalves.skipthedishes.repository.BaseIdLongRepository;

/**
 * Base Test
 *
 * @author frederico.alves
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class BaseTest<M extends LongModel, T extends BaseIdLongRepository<M>> {
	/**
	 * Logger
	 */
	protected Logger logger;

	public BaseTest(Logger logger) {
		this.logger = logger;
	}

    @Test
    public void testFindAll() {
    	logger.info("Testing findAll...");

    	Iterable<M> list = findAll();
    	assertNotNull(list);

        logger.info("FindAll results: " + list);
    }

    @Test
    public void testFindById1L() {
    	logger.info("Testing findById...");
    	M value = findById(1L);

    	assertNotNull(value);
    	assertThat(value.getId(), equalTo(1L));

        logger.info("FindById1L result: " + value);
    }

    /**
     * Find All
     *
     * @return
     */
	protected Iterable<M> findAll() {
		return getRepository().findAll();
	}

	/**
	 * Find by id
	 *
	 * @param id
	 * @return
	 */
	protected M findById(Long id) {
		return getRepository().findOne(id);
	}

	/**
	 * Base Repo
	 *
	 * @return
	 */
	protected abstract BaseIdLongRepository<M> getRepository();
}
