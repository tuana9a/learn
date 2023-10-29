package com.tuana9a.learnjavaspringweb.repository;

import com.tuana9a.learnjavaspringweb.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepo3 extends JpaRepository<Brand, Integer> {
    Optional<Brand> findByIdAndDeletedFalse(Integer id);

    long countByNameIsLikeAndDeletedFalse(String name);

    List<Brand> findByIdInAndDeletedFalse(List<Integer> ids);

    List<Brand> findByNameIsLikeAndDeletedFalse(String name);

    @Query("update Brand b set b.deleted = false where b.id = ?1")
    @Modifying
    @Transactional
    int updateDeletedFalse(Integer id);

    @Query("update Brand b set b.deleted = true where b.id = :id")
    @Modifying
    @Transactional
    int updateDeletedTrue(@Param("id") Integer id);

    boolean existsBrandByNameContains(String name);
}
