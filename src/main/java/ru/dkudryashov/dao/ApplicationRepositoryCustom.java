package ru.dkudryashov.dao;

import ru.dkudryashov.domain.Application;

/**
 * Created by Dmitry on 04.04.17.
 */
public interface ApplicationRepositoryCustom {

    Application findLast(Long contactId);

}
