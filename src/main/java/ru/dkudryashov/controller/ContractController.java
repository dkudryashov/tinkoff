package ru.dkudryashov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.dkudryashov.domain.Application;
import ru.dkudryashov.domain.Contact;
import ru.dkudryashov.service.BankService;

/**
 * Created by Dmitry on 04.04.17.
 */
@RestController
@RequestMapping(value = "/contact")
public class ContractController {

    private final BankService bankService;

    @Autowired
    public ContractController(BankService bankService) {
        this.bankService = bankService;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Contact getContract(@PathVariable Long id) {
        return bankService.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delContract(@PathVariable Long id) {
        bankService.deleteContact(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Long save(@RequestBody Contact contact) {
        return bankService.save(contact);
    }


    @RequestMapping(value = "/{id}/application", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Long addApplication(@PathVariable Long id,
                               @RequestBody Application application) {
        return bankService.saveApplication(id, application);
    }

    @RequestMapping(value = "/{id}/application", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Application getApplication(@PathVariable Long id) {
        return bankService.findLast(id);
    }

    @RequestMapping(value = "/application/{id}", method = RequestMethod.DELETE)
    public void deleteApplication(@PathVariable Long id) {
        bankService.deleteApplication(id);
    }



}
