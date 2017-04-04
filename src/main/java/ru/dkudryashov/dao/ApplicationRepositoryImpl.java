package ru.dkudryashov.dao;

import org.springframework.stereotype.Repository;
import ru.dkudryashov.domain.Application;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by Dmitry on 04.04.17.
 */
@Repository
public class ApplicationRepositoryImpl implements ApplicationRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Application findLast(Long contactId) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Application> query = builder.createQuery(Application.class);
        Root<Application> root = query.from(Application.class);

        CriteriaQuery<Application> select = query
                .select(root)
                .where(builder.equal(root.get("contact").get("id"), contactId))
                .orderBy(builder.desc(root.get("dtCreated")));

        return entityManager.createQuery(select).setMaxResults(1).getSingleResult();
    }


}
