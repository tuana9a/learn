package com.tuana9a.learnjavaspringweb.repository;

import com.tuana9a.learnjavaspringweb.entities.OrderHasProduct;
import com.tuana9a.learnjavaspringweb.entities.OrderHasProductKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderHasProductRepo3 extends JpaRepository<OrderHasProduct, OrderHasProductKey> {

    List<OrderHasProduct> findByKey_ProductId(Long id);

    List<OrderHasProduct> findByProduct_NameContains(String name);

    List<OrderHasProduct> findByOrder_Id(Long id);

    List<OrderHasProduct> findByOrder_User_Id(Long id);

    List<OrderHasProduct> findByOrder_User_NameContains(String name);

}
