package com.tuana9a.learnjavaspringweb.repository;

import com.tuana9a.learnjavaspringweb.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo2 extends JpaRepository<Order, Long> {

}
