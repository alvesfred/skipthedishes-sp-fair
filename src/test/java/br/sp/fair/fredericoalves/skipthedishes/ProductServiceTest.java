package br.sp.fair.fredericoalves.skipthedishes;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.sp.fair.fredericoalves.skipthedishes.services.OrderService;

/**
 * Customer Service Test
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class ProductServiceTest {
    @Autowired
    OrderService service;

    @Test
    public void testList() {
        // database is not null, maybe cache for a while
        assertNotNull(service.findAll());
    }
}
