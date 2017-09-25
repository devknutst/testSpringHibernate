package com.example.testboot.repository;

import com.example.testboot.Entity.Page;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.LinkedList;


@Repository
public class PageRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Collection<Page> findAll() {
       return new LinkedList<>();
    }

    public Page getPageById(int id) {
        return entityManager.find(Page.class, id);
    }

    public void deletePage(int id) {
        entityManager.remove(getPageById(id));
    }

    @Transactional
    public void insertPage(Page page) {
        entityManager.merge(page);
    }



}
