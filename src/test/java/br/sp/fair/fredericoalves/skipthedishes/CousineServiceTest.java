package br.sp.fair.fredericoalves.skipthedishes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import br.sp.fair.fredericoalves.skipthedishes.services.CustomerService;
import br.sp.fair.fredericoalves.skipthedishes.services.OrderItemService;

/**
 * Cousine Service Test
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class CousineServiceTest {
    @Autowired(required = true)
    CustomerService service;

    @Autowired(required = true)
    OrderItemService orderItemService;

    @Test
    public void testList() {
        // database is not null, maybe cache for a while
        //assertNotNull(service.findAll());
    }
}
