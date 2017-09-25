package com.example.testboot.repository;

import com.example.testboot.Entity.Side;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class SideRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Side getById(int id) {
        return entityManager.find(Side.class, id);
    }

    public void delete(int id) {
        entityManager.remove(getById(id));
    }

    @Transactional
    public void insert(Side side) {
        entityManager.merge(side);
    }

}
