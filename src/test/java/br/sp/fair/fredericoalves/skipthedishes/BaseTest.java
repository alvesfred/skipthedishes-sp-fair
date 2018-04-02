package br.sp.fair.fredericoalves.skipthedishes;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.function.Function;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import br.sp.fair.fredericoalves.skipthedishes.model.LongModel;
import br.sp.fair.fredericoalves.skipthedishes.repository.BaseIdLongRepository;
import br.sp.fair.fredericoalves.skipthedishes.security.Token;
import lombok.Getter;
import lombok.Setter;

/**
 * Base Test
 *
 * @author frederico.alves
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SkipTheDishesSPFairApp.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public abstract class BaseTest<M extends LongModel, T extends BaseIdLongRepository<M>> {

	private static final String SECURITY_CHARSET_TYPE = "US-ASCII";

	private static Function<Token, byte[]> funcEncodedAuth =
			token -> Base64.encode(token.getHeaderToken().getBytes(Charset.forName(SECURITY_CHARSET_TYPE)));

	private static Function<byte[], String> funcHeaderAuth = bytes -> "Basic " + new String(bytes);

	@LocalServerPort
	private int port;

	protected Function<String, String> funcURI = uri -> "http://localhost:" + port + uri;

	/**
	 * Logger
	 */
	@Getter
	@Setter
	protected Logger logger;

	private HttpHeaders headers = new HttpHeaders();

	@Before
	public void before() {
		headers.add("Authorization", createHttpAuthenticationHeaderValue("user", "password"));
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	}

	protected HttpHeaders getHttpHeaders() {
		return headers;
	}

	/**
	 * Rest template client to test webservices access
	 */
	@Getter
	@Autowired
	protected RestTemplate restTemplate;

	public BaseTest() {
		this.logger = LoggerFactory.getLogger(getClass().getName());
	}

	protected BaseTest(final Logger logger) {
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

	/**
	 * Header token
	 *
	 * @param userId
	 * @param password
	 * @return
	 */
	private String createHttpAuthenticationHeaderValue(String userId, String password) {
		final byte[] encodedAuth = funcEncodedAuth.apply(new Token(userId, password));
		return funcHeaderAuth.apply(encodedAuth);
	}
}
