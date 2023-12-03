package com.tuana9a.learnjavaspringweb.repository;

import com.tuana9a.learnjavaspringweb.entities.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class BrandRepo4 {

    @Autowired
    private EntityManager entityManager;

    public List<Brand> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Brand> criteriaQuery = builder.createQuery(Brand.class);
        Root<Brand> root = criteriaQuery.from(Brand.class);
        criteriaQuery.select(root);
        TypedQuery<Brand> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public Brand findById(Long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Brand> criteriaQuery = builder.createQuery(Brand.class);
        Root<Brand> root = criteriaQuery.from(Brand.class);

        Predicate predicateId = builder.equal(root.get("id"), id);
        Predicate predicateDeletedFalse = builder.equal(root.get("deleted"), false);
        Predicate finalPredicate = builder.and(predicateId, predicateDeletedFalse);

        criteriaQuery.select(root).where(finalPredicate);

        TypedQuery<Brand> query = entityManager.createQuery(criteriaQuery);



        return query.getSingleResult();
    }

}
