package com.tuana9a.learnjavaspringweb.repository;

import com.tuana9a.learnjavaspringweb.entities.Product;
import com.tuana9a.learnjavaspringweb.dto.CountGroupBy;
import com.tuana9a.learnjavaspringweb.dto.CountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class ProductRepo1 {

    @Autowired
    // @PersistenceContext
    // @Autowired và @Persistence context có sự khác nhau
    private EntityManager entityManager;

    public Product findById(Long id) {
        String sql = "SELECT e FROM Product e WHERE e.id = ?1 AND e.deleted = false";
        TypedQuery<Product> query = entityManager.createQuery(sql, Product.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    public List<Product> findBy(String name, String value) {
        String sql = "SELECT e FROM Product e WHERE e.:name = :value AND e.deleted = false";
        TypedQuery<Product> query = entityManager.createQuery(sql, Product.class);
        query.setParameter("name", name);
        query.setParameter("value", value);
        query.setMaxResults(10);
        return query.getResultList();
    }

    public List<Product> findAll() {
        String sql = "SELECT e FROM Product e WHERE e.deleted = false";
        TypedQuery<Product> query = entityManager.createQuery(sql, Product.class);
        return query.getResultList();
    }


    public Long countAll() {
        String sql = "SELECT count(e) FROM Product e WHERE e.deleted = false";
        return entityManager.createQuery(sql, Long.class)
                .getSingleResult();
    }

    public CountEntity customCountAll() {
        String sql = "SELECT " +
                "new com.tuana9a.learnjavaspringboot.models.CountEntity('Count Product',count(e)) " +
                "FROM Product e " +
                "WHERE e.deleted = false";
        return entityManager.createQuery(sql, CountEntity.class)
                .getSingleResult();
    }

    public List<CountGroupBy> countGroupByBrand() {
        String sql = "SELECT " +
                "new com.tuana9a.learnjavaspringboot.models.CountGroupBy(e.brand.name,count(e)) " +
                "FROM Product e " +
                "WHERE e.deleted = false " +
                "GROUP BY e.brand";
        return entityManager.createQuery(sql, CountGroupBy.class)
                .getResultList();
    }

    public void insert(Product brand) {
        String sql = "INSERT INTO "; // TODO
        Query query = entityManager.createQuery(sql);
        query.setLockMode(LockModeType.OPTIMISTIC);
    }

    public void update(Product product) {
        String sql = "UPDATE"; // TODO
        Query query = entityManager.createQuery(sql);
        query.setLockMode(LockModeType.WRITE);
        // LockModeType.READ    cấm thằng khác sửa, xóa khi tao đang đọc
        // LockModeType.WRITE	cấm thằng khác đọc, sửa, xóa khi tao đang sửa
        query.executeUpdate();
    }

    public void delete(Long id) {
        Product object = entityManager.find(Product.class, id);
        entityManager.remove(object);
    }
}
