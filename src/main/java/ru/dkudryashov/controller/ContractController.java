package ru.dkudryashov.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.dkudryashov.domain.Application;
import ru.dkudryashov.domain.Contact;
import ru.dkudryashov.service.interfaces.BankService;

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

    @ApiOperation(value = "Find contact in database by id", httpMethod = "GET", response = Contact.class)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Contact getContract(@PathVariable Long id) {
        return bankService.findById(id);
    }

    @ApiOperation(value = "Delete contact in database by id", httpMethod = "DELETE")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delContract(@PathVariable Long id) {
        bankService.deleteContact(id);
    }

    @ApiOperation(value = "Save new contact in database", httpMethod = "POST", response = Long.class)
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Long save(@RequestBody Contact contact) {
        return bankService.save(contact);
    }


    @ApiOperation(value = "Get last application from user", httpMethod = "GET", response = Application.class)
    @RequestMapping(value = "/{id}/application", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Application getApplication(@PathVariable Long id) {
        return bankService.findLast(id);
    }

    @ApiOperation(value = "Save new application from contact", httpMethod = "POST", response = Long.class)
    @RequestMapping(value = "/{contactId}/application", method = RequestMethod.POST)
    public Long addApplication(@PathVariable Long contactId,
                               @RequestBody Application application) {
        return bankService.saveApplication(contactId, application);
    }

    @ApiOperation(value = "Delete application in database by id", httpMethod = "DELETE")
    @RequestMapping(value = "/application/{id}", method = RequestMethod.DELETE)
    public void deleteApplication(@PathVariable Long id) {
        bankService.deleteApplication(id);
    }



}
