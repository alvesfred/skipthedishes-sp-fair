package br.sp.fair.fredericoalves.skipthedishes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Main App Test
 *
 * @author frederico.alves
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SkipTheDishesAppTest {

	@Test
    public void contextLoads() {
    }

}
