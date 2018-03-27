package br.sp.fair.fredericoalves.skipthedishes;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import br.sp.fair.fredericoalves.skipthedishes.model.LongModel;
import br.sp.fair.fredericoalves.skipthedishes.repository.BaseIdLongRepository;
import lombok.Getter;
import lombok.Setter;

/**
 * Base Test
 *
 * @author frederico.alves
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public abstract class BaseTest<M extends LongModel, T extends BaseIdLongRepository<M>> {

	/**
	 * Logger
	 */
	@Getter
	@Setter
	protected Logger logger;

	/**
	 * Rest template client to test webservices access
	 */
	@Getter
	@Autowired
	protected RestTemplate restTemplate;

	public BaseTest() {
		this(LoggerFactory.getLogger(BaseTest.class));
	}

	private BaseTest(final Logger logger) {
		setLogger(logger);
	}

    @Test
    public void testFindAll() {
    	getLogger().info("Testing findAll...");

    	Iterable<M> list = findAll();
    	assertNotNull(list);

    	getLogger().info("FindAll results: " + list);
    }

    @Test
    public void testFindById1L() {
    	getLogger().info("Testing findById...");
    	M value = findById(1L);

    	assertNotNull(value);
    	assertThat(value.getId(), equalTo(1L));

    	getLogger().info("FindById1L result: " + value);
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
