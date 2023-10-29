package com.tuana9a.learnjavaspringweb.services;

import com.tuana9a.learnjavaspringweb.specification.SpecificationBuilder;
import com.tuana9a.learnjavaspringweb.dto.PageJsonResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public abstract class BaseService5<T> {

    private final JpaSpecificationExecutor<T> repo;
    private final Class<T> _class;
    private final EntityManager entityManager;

    public BaseService5(JpaSpecificationExecutor<T> repo, Class<T> _class, EntityManager entityManager) {
        this.repo = repo;
        this._class = _class;
        this.entityManager = entityManager;
    }

    @SuppressWarnings("unchecked")
    public T save(T data) throws Exception {
        return ((JpaRepository<T, Integer>) repo).save(data);
    }

    public void delete(Integer id) throws Exception {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<T> criteria = builder.createCriteriaUpdate(_class);
        Root<T> root = criteria.from(_class);
        criteria.set("deleted", true).where(builder.equal(root.get("id"), id));
    }

    public List<T> filter(List<String> criteria, String sortRequest) throws Exception {
        return resolveSort(sortRequest)
                .map(sort -> repo.findAll(new SpecificationBuilder<T>().resolve(criteria), sort))
                .orElse(repo.findAll(new SpecificationBuilder<T>().resolve(criteria)));
    }

    public PageJsonResponse<T> filter(List<String> criteria, Pageable pageable, String sortRequest) throws Exception {
        return resolveSort(sortRequest)
                .map(sort -> new PageJsonResponse<T>(repo.findAll(new SpecificationBuilder<T>().resolve(criteria), PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort))))
                .orElse(new PageJsonResponse<T>(repo.findAll(new SpecificationBuilder<T>().resolve(criteria), PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()))));
    }

    private Optional<Sort> resolveSort(String sortRequest) {
        Sort sort = null;
        try {
            String[] manySorts = sortRequest.trim().replaceAll("\\s+", "").split(",");
            for (String singleSort : manySorts) {
                String[] parts = singleSort.split("-");
                String field = parts[0];
                Sort temp = Sort.by(Sort.Direction.ASC, field);
                if (parts.length == 2 && parts[1].equalsIgnoreCase("desc")) {
                    temp = Sort.by(Sort.Direction.DESC, field);
                }
                if (sort == null) {
                    sort = temp;
                } else {
                    sort = sort.and(temp);
                }
            }
            if (sort == null)
                return Optional.empty();
            return Optional.of(sort);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
