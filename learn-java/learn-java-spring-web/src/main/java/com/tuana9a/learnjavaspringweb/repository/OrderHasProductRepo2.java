package com.tuana9a.learnjavaspringweb.repository;

import com.tuana9a.learnjavaspringweb.entities.OrderHasProduct;
import com.tuana9a.learnjavaspringweb.entities.OrderHasProductKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHasProductRepo2 extends JpaRepository<OrderHasProduct, OrderHasProductKey> {

}
