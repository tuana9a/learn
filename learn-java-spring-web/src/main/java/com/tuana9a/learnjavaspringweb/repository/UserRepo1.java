package com.tuana9a.learnjavaspringweb.repository;

import com.tuana9a.learnjavaspringweb.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class UserRepo1 {

    // @Autowired
    @PersistenceContext
    // @Autowired và @Persistence context có sự khác nhau
    private EntityManager entityManager;

    public User findById(Long id) {
        // hàm find tìm theo khóa chính
        // object trả về thay đổi có thể thay đổi luôn trong db nếu nằm trong một transaction
        // CAUTION: cần kiểm tra lại
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void persist(User object) {
        // thêm object mới vào db
        entityManager.persist(object);
    }

    @Transactional
    public User merge(User object) {
        // CAUTION: đây là mình nhớ như vậy, cần phải test để kiểm tra lại
        // object trả về từ hàm merge khi thay đổi có thể sẽ cập nhật luôn trong db
        return entityManager.merge(object);
    }

    @Transactional
    public void remove(Long id) {
        // để remove dùng đồ có sẵn phải lấy được reference (proxy) của object trong persistence context trước
        // sau đó để thằng remove làm nốt nhiệm vụ của nó
        User object = entityManager.find(User.class, id);
        entityManager.remove(object);
    }

    public User getReference(Long id) {
        // trả về tham chiếu với object trong persistence context
        return entityManager.getReference(User.class, id);
    }

}
