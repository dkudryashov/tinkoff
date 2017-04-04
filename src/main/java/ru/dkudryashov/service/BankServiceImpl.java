package ru.dkudryashov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dkudryashov.dao.ApplicationRepository;
import ru.dkudryashov.dao.ContactRepository;
import ru.dkudryashov.domain.Application;
import ru.dkudryashov.domain.Contact;
import ru.dkudryashov.service.interfaces.BankService;

import java.sql.Date;
import java.util.Objects;

/**
 * Created by Dmitry on 04.04.17.
 */
@Service
public class BankServiceImpl implements BankService {

    private final ContactRepository contactRepository;
    private final ApplicationRepository applicationRepository;

    @Autowired
    public BankServiceImpl(ContactRepository contactRepository, ApplicationRepository applicationRepository) {
        this.contactRepository = contactRepository;
        this.applicationRepository = applicationRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Contact findById(Long id) {
        return contactRepository.findOne(id);
    }

    @Override
    @Transactional
    public Long save(Contact contact) {
        return contactRepository.save(contact).getId();
    }

    @Override
    @Transactional
    public Long saveApplication(Long contactId, Application application) {
        application.setContact(new Contact(contactId));
        application.setDtCreated(
                Objects.isNull(application.getDtCreated()) ? new Date(System.currentTimeMillis()) : application.getDtCreated()
        );
        return applicationRepository.save(application).getId();
    }

    @Override
    @Transactional(readOnly = true)
    public Application findLast(Long contactId) {
        return applicationRepository.findLast(contactId);
    }

    @Override
    @Transactional
    public void deleteContact(Long id) {
        contactRepository.delete(id);
    }

    @Override
    @Transactional
    public void deleteApplication(Long id)  {
        applicationRepository.delete(id);
    }

}
