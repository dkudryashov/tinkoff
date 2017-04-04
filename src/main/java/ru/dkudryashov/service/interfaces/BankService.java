package ru.dkudryashov.service.interfaces;

import ru.dkudryashov.domain.Application;
import ru.dkudryashov.domain.Contact;

/**
 * Created by Dmitry on 04.04.17.
 */
public interface BankService {

    /**
     * Find {@link Contact} by id
     * @param id contact
     * @return {@link Contact}
     */
    Contact findById(Long id);

    /**
     * Save new {@link Contact}
     * @param contact {@link Contact}
     * @return {@link Long} id new contact
     */
    Long save(Contact contact);

    /**
     * Save new application
     * @param contactId {@link Long} Contact id
     * @param application {@link Application} application data
     * @return {@link Long} id new application
     */
    Long saveApplication(Long contactId, Application application);

    /**
     * Find last {@link Application} (order create date application)
     * @param contactId {@link Long} contact id
     * @return last {@link Application}
     */
    Application findLast(Long contactId);

    /**
     * Delete {@link Contact} by id
     * @param id contact
     */
    void deleteContact(Long id);

    /**
     * Delete {@link Application} by id
     * @param id application
     */
    void deleteApplication(Long id);
}
