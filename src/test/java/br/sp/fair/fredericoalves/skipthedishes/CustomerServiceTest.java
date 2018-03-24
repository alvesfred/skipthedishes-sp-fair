package br.sp.fair.fredericoalves.skipthedishes;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.sp.fair.fredericoalves.skipthedishes.services.CustomerService;

/**
 * Customer Service Test
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {
    @Autowired(required = true)
    CustomerService service;

    @Test
    public void testList() {
        // database is not null, maybe cache for a while
        assertNotNull(service.findAll());
    }
}
