package ru.dkudryashov.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dkudryashov.domain.Contact;

/**
 * Created by Dmitry on 04.04.17.
 */
@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {

}
