package ru.dkudryashov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dkudryashov.dao.ApplicationRepository;
import ru.dkudryashov.dao.ContactRepository;
import ru.dkudryashov.domain.Application;
import ru.dkudryashov.domain.Contact;

/**
 * Created by Dmitry on 04.04.17.
 */
@Service
public class BankService {

    private final ContactRepository contactRepository;
    private final ApplicationRepository applicationRepository;

    @Autowired
    public BankService(ContactRepository contactRepository, ApplicationRepository applicationRepository) {
        this.contactRepository = contactRepository;
        this.applicationRepository = applicationRepository;
    }


    @Transactional(readOnly = true)
    public Contact findById(Long id) {
        return contactRepository.findOne(id);
    }

    @Transactional
    public Long save(Contact contact) {
        return contactRepository.save(contact).getId();
    }

    @Transactional
    public Long saveApplication(Long id, Application application) {
        application.setContact(new Contact(id));
        return applicationRepository.save(application).getId();
    }

    @Transactional(readOnly = true)
    public Application findLast(Long contactId) {
        return applicationRepository.findLast(contactId);
    }

    @Transactional
    public void deleteContact(Long id) {
        contactRepository.delete(id);
    }

    @Transactional
    public void deleteApplication(Long id)  {
        applicationRepository.delete(id);
    }

}
