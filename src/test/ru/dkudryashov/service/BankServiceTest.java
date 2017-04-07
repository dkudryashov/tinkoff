package ru.dkudryashov.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.dkudryashov.Application;
import ru.dkudryashov.domain.Contact;
import ru.dkudryashov.service.interfaces.BankService;

import java.sql.Date;


/**
 * Created by Dmitry on 04.04.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
@TestPropertySource(locations = "classpath:application.properties")
public class BankServiceTest {

    @Autowired
    private BankService bankService;

    @Test
    public void findById() throws Exception {
        Contact before = new Contact(1L);
        Contact after = bankService.findById(1L);

        Assert.assertEquals(before, after);
    }

    @Test
    public void save() throws Exception {
        Contact before = new Contact();
        Long save = bankService.save(before);
        before.setId(save);

        Contact after = bankService.findById(save);
        Assert.assertEquals(before, after);
    }

    @Test
    public void findLast() throws Exception {
        ru.dkudryashov.domain.Application last = bankService.findLast(1L);

        ru.dkudryashov.domain.Application application = new ru.dkudryashov.domain.Application();
        application.setId(2L);
        application.setContact(new Contact(1L));
        application.setProductName("app2_1");
        application.setDtCreated(new Date(115, 0, 02));

        Assert.assertEquals(last, application);
    }

    @Test
    public void deleteContact() throws Exception {
        bankService.deleteContact(1L);
        Contact contact = bankService.findById(1L);

        Assert.assertNull(contact);
    }


}